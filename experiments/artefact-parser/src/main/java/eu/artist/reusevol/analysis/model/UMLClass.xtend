package eu.artist.reusevol.analysis.model

import java.util.List

class UMLClass extends UMLElement {
	val List<String> methods = newArrayList()
	
	new(String name, String id) {
		super(name, id)
	}
	
	def getMethods() {
		methods
	}
}