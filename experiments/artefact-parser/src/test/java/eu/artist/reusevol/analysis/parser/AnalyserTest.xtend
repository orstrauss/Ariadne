package eu.artist.reusevol.analysis.parser

import org.junit.Test
import java.io.File

class AnalyserTest {
	@Test
	def void testCreateInstance() {
		val analyser = new Analyser(new File("src/test/resources/test-input/PetstoreCloudModel/GoogleAppEngineDeployment.uml"));
		analyser.run
	}	
}