package eu.artist.reusevol.analysis.model

import java.util.List

class UMLContainer extends UMLElement {
	val List<UMLElement> content = newArrayList()
	
	new(String name, String id) {
		super(name, id)
	}
	
	def getContent() {
		content
	}
}