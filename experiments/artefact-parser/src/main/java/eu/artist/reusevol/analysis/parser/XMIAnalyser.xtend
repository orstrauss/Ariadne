package eu.artist.reusevol.analysis.parser

import com.google.common.base.Splitter
import java.io.File
import java.io.FileInputStream
import java.util.List
import java.util.Map
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamConstants

class XMIAnalyser {
	val factory = XMLInputFactory.newInstance()

	new() {
	}

	def parse(File input) {
		val in = new FileInputStream(input)
		val parser = factory.createXMLStreamReader(in)
		val result = new XMIAnalysisResult(input)
		
		val List<String> path = newLinkedList
		
		while (parser.hasNext()) {
			switch parser.eventType {
				case XMLStreamConstants.START_DOCUMENT: {
					// println("START_DOCUMENT: " + parser.version)
				}
				case XMLStreamConstants.END_DOCUMENT: {
					// println("END_DOCUMENT: ");
					parser.close()
				}
				case XMLStreamConstants.NAMESPACE: {
					// println("NAMESPACE: " + parser.namespaceURI)
				}
				case XMLStreamConstants.START_ELEMENT: {					
					path.add(parser.localName)
					// println("START_ELEMENT: " + parser.localName)
					// println("  PATH: " + path.join("->"))
					
					if (parser.namespaceCount > 0) {
						// println("  Namespace declarations: " + parser.namespaceCount)
						for (i : 0 ..< parser.namespaceCount) {
							// println('''    Namespace «i»: «parser.getNamespacePrefix(i)» -> «parser.getNamespaceURI(i)»''')
							result.nsMapping.put(parser.getNamespacePrefix(i), parser.getNamespaceURI(i))
						}
					}
					
					// Der Event XMLStreamConstants.ATTRIBUTE wird nicht geliefert!
					for (i : 0 ..< parser.attributeCount) {
						processAttribute(parser.getAttributeLocalName(i).toString, parser.getAttributeValue(i), result)
						// println('''  Attribut «parser.getAttributeLocalName(i)» = '«parser.getAttributeValue(i)»' ''')
					}
				}
				case XMLStreamConstants.CHARACTERS: {
					// if (! parser.whiteSpace)
						// println("  CHARACTERS: " + parser.text)
				}
				case XMLStreamConstants.END_ELEMENT: {
					path.remove(path.length - 1)
					// println("END_ELEMENT: " + parser.localName)
				}
			}
			parser.next();
		}
		result
	}
	
	def processSchemaLocation(String mapping) {
		val Map<String,String> schemas = newHashMap
		val parts = Splitter.on(" ").split(mapping).iterator
		
		while(parts.hasNext) {
			schemas.put(parts.next, parts.next)
		}
		schemas
	}

	def processAttribute(String name, String value, XMIAnalysisResult result) {
		switch name.toLowerCase {
			case "href": {
				result.references.add(value)
			}
			//case "source": {
			//	result.references.add(value)
			//	println('''  Attribut «name» = '«value»' ''')
			//}
			case "schemalocation": {
				result.schemaMapping.putAll(processSchemaLocation(value))
			}
		}
	}
	
}
