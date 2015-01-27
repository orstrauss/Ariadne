package eu.artist.reusevol.analysis.parser;

import eu.artist.reusevol.analysis.parser.StaxParser;
import org.junit.Test;

@SuppressWarnings("all")
public class StaxParserTest {
  @Test
  public void testCreateInstance() {
    final String file = "src/test/resources/test-input/PetstoreCloudModel/GoogleAppEngineDeployment.uml";
    final StaxParser parser = new StaxParser(file);
    parser.parseWithEvents(file);
  }
}
