package eu.artist.reusevol.analysis.parser;

import eu.artist.reusevol.analysis.parser.Analyser;
import java.io.File;
import org.junit.Test;

@SuppressWarnings("all")
public class AnalyserTest {
  @Test
  public void testCreateInstance() {
    File _file = new File("src/test/resources/test-input/PetstoreCloudModel/GoogleAppEngineDeployment.uml");
    final Analyser analyser = new Analyser(_file);
    analyser.run();
  }
}
