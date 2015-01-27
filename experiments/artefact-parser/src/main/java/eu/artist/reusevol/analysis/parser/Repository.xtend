package eu.artist.reusevol.analysis.parser

import java.util.List

@Data
class Repository {
	val List<Representation> artefacts = newArrayList
	val List<Relationship> relations = newArrayList
}