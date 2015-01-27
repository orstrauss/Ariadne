package eu.artist.reusevol.analysis.model

import java.util.Map

@Data
class XMLArtefact extends FileArtefact {
	Map<String, String> nsMapping = newHashMap
	Map<String, String> schemaLocation = newHashMap
}