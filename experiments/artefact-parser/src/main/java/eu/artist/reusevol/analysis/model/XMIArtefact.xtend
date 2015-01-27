package eu.artist.reusevol.analysis.model

import java.util.List
import java.util.Set
import java.util.Stack

class XMIArtefact extends XMLArtefact {
	val List<String> references = newArrayList
	var boolean xmiRootElement
	val List<UMLElement> classes = newArrayList
	val uml = new Stack<UMLElement>()
	
	new(String filename, String localPath) {
		super(filename, localPath)
		xmiRootElement = false
	}
	
	def getReferences() {
		references
	}
	
	def getClasses() {
		classes
	}
	
	def getUMLStack() {
		uml
	}
	
	def hasXmiRootElement() {
		xmiRootElement
	}
	
	def setXmiRootElement(boolean xmi) {
		xmiRootElement = xmi
	}
	
	def getSysIdReferences() {
		getReferencesWithPrefix("http://")
	}
	
	def getLocalReferences() {
		val Set<String> localIds = newHashSet
		references.forEach[
			val mainPart = split("#").get(0)
			if (!mainPart.contains("://")) {
				localIds.add(mainPart)
			}
		]
		localIds
	}

	def getReferencesWithPrefix(String prefix) {
		val Set<String> ids = newHashSet
		references.forEach[
			val mainPart = split("#").get(0)
			if (mainPart.startsWith(prefix)) {
				ids.add(mainPart)
			}
		]
		ids
	}
}