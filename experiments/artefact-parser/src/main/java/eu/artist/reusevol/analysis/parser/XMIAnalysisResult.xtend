package eu.artist.reusevol.analysis.parser

import java.io.File
import java.util.Map
import java.util.Set

@Data
class XMIAnalysisResult {
	val File file
	val Map<String,String> nsMapping = newHashMap
	val Map<String,String> schemaMapping = newHashMap
	val Set<String> references = newHashSet
	
	def refSet() {
		val Set<String> allRefs = newHashSet
		allRefs.addAll(references.map[ split('#').iterator.next ])
		allRefs.addAll(schemaMapping.values.map[ split('#').iterator.next ])
		allRefs
	}
	
	def fileReferences() {
		refSet.filter[ !(startsWith("http") || startsWith("pathmap")) ].map[
			val path = new File(file.parent + File::separator + split('#').iterator.next).toPath.normalize.toString 
			new File(path)
		]
	}

	def externalReferences() {
		refSet.filter[ startsWith("http") ]
	}

	def internalReferences() {		
		refSet.filter[ startsWith("pathmap") ]
	}
	
	override toString() {
		val result = new StringBuilder
		result.append("<File: ").append(file.name)
		nsMapping.forEach[key, value | 
			result.append("\n  Namespace ").append(key).append(" -> ").append(value)
		]
		schemaMapping.forEach[key, value | 
			result.append("\n  Schema    ").append(key).append(" -> ").append(value)
		]
		fileReferences.forEach[key | 
			result.append("\n  Local     ").append(key)
		]
		externalReferences.forEach[key | 
			result.append("\n  Extern    ").append(key)
		]
		internalReferences.forEach[key | 
			result.append("\n  Intern    ").append(key)
		]
		result.append("\n");
		result.toString
	}
}
