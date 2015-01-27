package eu.artist.reusevol.analysis.parser

import java.io.File
import java.util.Set

class Analyser {
	val Set<File> toDo = newHashSet 
	val Set<File> processed = newHashSet
	val Set<XMIAnalysisResult> closure = newHashSet
	val xmi = new XMIAnalyser 
	
	new(File start) {
		toDo.add(start)
	}
	
	def run() {
		while(!toDo.empty) {
			val current = toDo.get(0)
			println("Analysing file " + current.absolutePath)
			analyseFile(current)
			toDo.remove(current)
			processed.add(current)
		}
		println(closure)
	}
	
	def analyseFile(File file) {
		val result = xmi.parse(file)
		closure.add(result)
		toDo.addAll(result.fileReferences.filter[!processed.contains(it)])
	}	
}