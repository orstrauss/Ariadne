package eu.artist.reusevol.analysis.parser

import com.google.common.base.Splitter
import com.google.common.base.Strings
import java.io.File
import java.io.FileInputStream
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamConstants
import javax.xml.stream.XMLStreamReader
import javax.xml.stream.events.Attribute
import javax.xml.stream.events.EndElement
import javax.xml.stream.events.Namespace
import javax.xml.stream.events.StartElement
import javax.xml.stream.events.XMLEvent
import org.codehaus.stax2.XMLInputFactory2
import java.util.Stack
import javax.xml.stream.events.Characters
import eu.artist.reusevol.analysis.model.XMIArtefact
import javax.xml.ws.soap.AddressingFeature.Responses
import javax.xml.namespace.QName
import eu.artist.reusevol.analysis.model.UMLContainer
import eu.artist.reusevol.analysis.model.UMLClass
import eu.artist.reusevol.analysis.model.UMLModel
import eu.artist.reusevol.analysis.model.UMLPackage

class StaxParser {
	val String filename
	val XMLStreamReader parser
	val Set<String> hrefs
	val Map<String,String> schemas
	val List<String> path = newLinkedList
	val stack = new Stack<XMLEvent>();

	new(String filename) {
		this.filename = filename;
		
		hrefs = new HashSet<String>()
		schemas = new HashMap<String,String>()
		
		val in = new FileInputStream(filename)
		val factory = XMLInputFactory.newInstance()
		parser = factory.createXMLStreamReader(in)
	}
	
	def parseWithEvents(String filename) {
		val input = new File(filename)
		val in = new FileInputStream(input)
		val factory = XMLInputFactory2.newInstance()
		val references = new RecordingXMLResolver
		factory.XMLResolver = references
		val events = factory.createXMLEventReader(in)
		val context = new XMIArtefact(input.name, input.absolutePath)
		
		while(events.hasNext) {
			val event = events.nextEvent
			switch event.eventType {
				case XMLEvent.START_ELEMENT : processEvent(event.asStartElement, context)
				case XMLEvent.END_ELEMENT : processEvent(event.asEndElement, context)
				// case XMLEvent.CHARACTERS : processEvent(event.asCharacters)
			}			
		}
		println(context)
		println(context.sysIdReferences)
		println(context.localReferences)
		println(context.getReferencesWithPrefix("pathmap://"))
	}
	
	def processEvent(StartElement event, XMIArtefact ctx) {
		stack.push(event)
		
		if(event.name.localPart.equalsIgnoreCase("xmi") && (event.getNamespaceURI("xmi") != null) && event.getNamespaceURI("xmi").startsWith("http://www.omg.org/spec/XMI")) {
			ctx.xmiRootElement = true
			println(":XMI Root Element")
		}
		
		if (!event.namespaces.empty) {
			event.namespaces.toList.forEach[ Namespace a | ctx.nsMapping.put(a.name.localPart, a.value) ]
			println(":Namespaces "  + ctx.nsMapping)
		}
		
		val location = event.getAttributeByName(new QName(event.getNamespaceURI("xsi"), "schemaLocation"))
		if (location != null) {
			val parts = location.value.split(" ").iterator
			while(parts.hasNext) {
				val source = parts.next
				val dest = parts.next
				ctx.schemaLocation.put(source, dest)
				ctx.references.add(dest)
			}
			println(":SchemaLocation " + ctx.schemaLocation)
		}

		val href = event.getAttributeByName(new QName("href"))
		if (href != null) {
			ctx.references.add(href.value)
		}
		
		println("Event: " + event.name + " - " + breadcrumps)
		breadcrumps
		println("  att: " + event.attributes.toList.map[ Attribute a | a.name.localPart + "=" + a.value])
		
		if (event.name.prefix.equalsIgnoreCase("uml") && event.name.localPart.equalsIgnoreCase("model")) {
			val id = event.getAttributeByName(new QName(event.getNamespaceURI("xmi"), "id"))
			val name = event.getAttributeByName(new QName("name"))
			val element = new UMLModel(name?.value, id?.value)
			ctx.classes.add(element)
			ctx.UMLStack.push(element) 
		}
		if (event.name.localPart.equalsIgnoreCase("packagedElement") || event.name.localPart.equalsIgnoreCase("ownedAttribute")) {
			processUML(event, ctx)
		}
	}
	
	def processUML(StartElement event, XMIArtefact ctx) {
		val type = event.getAttributeByName(new QName(event.getNamespaceURI("xmi"), "type"))
		if (type == null) return
		val name = event.getAttributeByName(new QName("name"))
		if (name != null) {
			println('''*** Found UML element '«name.value»' of type «type.value».''')
			val stack = ctx.UMLStack 
			switch(type.value.toLowerCase) {
				case "uml:package": {
					val id = event.getAttributeByName(new QName(event.getNamespaceURI("xmi"), "id"))
					val element = new UMLPackage(name.value, id?.value)
					(stack.peek as UMLContainer).content.add(element)
					stack.push(element)
				}
				case "uml:class": {
					val id = event.getAttributeByName(new QName(event.getNamespaceURI("xmi"), "id"))
					val element = new UMLClass(name.value, id?.value)
					(stack.peek as UMLContainer).content.add(element)
					// stack.push(element)
				}
				case "uml:property": {
					// (stack.peek as UMLClass).methods.add(name?.value)
				}
			}
		}
	}

	def processEvent(EndElement event, XMIArtefact ctx) {
		println("--- EndEvent: " + event.name)
		println("  nss: " + event.namespaces.toList.map[ Namespace a | a.name.localPart + "=" + a.value])
		stack.pop
	}
	
	def processEvent(Characters event) {
		println("===: " + event.data)
	}
	
	def breadcrumps() {
		stack.map[ e | (e as StartElement).name.localPart].join("/")
	}
	
	def parseWithCursor() {
		// What do I use from cursor
		// parser:    eventType, version, namespaceURI, localName, 
		// Attribute: localName, value, qname
		// 
		
		
		while (parser.hasNext()) {
			// println("Event-Type: " + parser.eventType)
			
			switch parser.eventType {
				case XMLStreamConstants.START_DOCUMENT: {
					println("START_DOCUMENT: " + parser.version)
				}
				case XMLStreamConstants.END_DOCUMENT: {
					println("END_DOCUMENT: ");
					parser.close()
				}
				case XMLStreamConstants.NAMESPACE: {
					println("NAMESPACE: " + parser.namespaceURI)
				}
				case XMLStreamConstants.START_ELEMENT: {					
					path.add(parser.localName)
					println("START_ELEMENT: " + parser.localName)
					println("  PATH: " + path.join("->"))
					printNamespaceInfo()
					
					// Der Event XMLStreamConstants.ATTRIBUTE wird nicht geliefert!
					for (i : 0 ..< parser.attributeCount) {
						switch parser.getAttributeLocalName(i).toString.toLowerCase {
							case "href": processHref(parser.getAttributeValue(i), parser.localName)
							case "source": processHref(parser.getAttributeValue(i), parser.localName)
							case "schemalocation": processSchemaLocation(parser.getAttributeValue(i))
						}
							
						println('''  Attribut «parser.getAttributeLocalName(i)» = '«parser.getAttributeValue(i)»' ''')
					}
				}
				case XMLStreamConstants.CHARACTERS: {
					if (! parser.whiteSpace)
						println("  CHARACTERS: " + parser.text)
				}
				case XMLStreamConstants.END_ELEMENT: {
					path.remove(path.length - 1)
					println("END_ELEMENT: " + parser.localName)
				}
			}
			parser.next();
		}
		
		hrefs.forEach[ println(" - Link: " + it)]
		schemas.forEach[ k,v |  println(''' - Mapping «k» -> «v»''')]
		files
	}
	
	def printNamespaceInfo() {
		if (!Strings.isNullOrEmpty(parser.prefix)) {
			println("  Namespace prefix: " + parser.prefix)
		}
		if (parser.namespaceCount > 0) {
			println("  Namespace declarations: " + parser.namespaceCount)
			for (i : 0 ..< parser.namespaceCount) {
				println('''    Namespace «i»: «parser.getNamespacePrefix(i)» -> «parser.getNamespaceURI(i)»''')
			}
		}
	}
	
	def processHref(String link, String tag) {
		switch tag {
			case "importedPackage": println("    Package import from " + link)
			case "type": println("    Type reference to " + link)
			default: println("    href in tag " + tag) 
		}
		hrefs.add(link)
	}
	
	def processSchemaLocation(String mapping) {
		println("--- SchemaLocation ---")
		val parts = Splitter.on(" ").split(mapping).iterator
		while(parts.hasNext) {
			schemas.put(parts.next, parts.next)
		}
	}
	
	def files() {
		val splitter = Splitter.on("#")
		val files = new HashSet<String>()
		hrefs.filter[ !(startsWith("http") || startsWith("pathmap")) ].forEach[
			files.add(splitter.split(it).iterator.next)
		]
		schemas.forEach[ k,v | files.add(splitter.split(v).iterator.next) ]
		files.sortBy[ it ].forEach[ println(" - File: " + (new File(it)).canonicalPath ) ]
		hrefs.filter[ startsWith("http") ].forEach[ println(" - Webref: " + it) ] 
		hrefs.filter[ startsWith("pathmap") ].forEach[ println(" - Localref: " + it) ] 
	}
	
}
