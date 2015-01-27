package eu.artist.reusevol.analysis.parser;

import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class RecordingXMLResolver implements XMLResolver {
  public RecordingXMLResolver() {
  }
  
  public Object resolveEntity(final String publicID, final String systemID, final String baseURI, final String namespace) throws XMLStreamException {
    InputOutput.<String>println(((((((("External reference: publicId=" + publicID) + ", systemId=") + systemID) + ", baseUri=") + baseURI) + ", ns=") + namespace));
    return null;
  }
}
