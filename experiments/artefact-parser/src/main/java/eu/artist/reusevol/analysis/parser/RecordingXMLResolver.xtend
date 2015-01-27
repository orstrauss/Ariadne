package eu.artist.reusevol.analysis.parser

import javax.xml.stream.XMLResolver
import javax.xml.stream.XMLStreamException

class RecordingXMLResolver implements XMLResolver {
	new() {
		
	}
	
	override resolveEntity(String publicID, String systemID, String baseURI, String namespace) throws XMLStreamException {
		println("External reference: publicId=" + publicID + ", systemId=" + systemID + ", baseUri=" + baseURI + ", ns=" + namespace)
		return null
	}	
}