package eu.artist.reusevol.analysis.parser

import org.junit.Test

class StaxParserTest {
	@Test
	def void testCreateInstance() {
		val file = "src/test/resources/test-input/PetstoreCloudModel/GoogleAppEngineDeployment.uml"
		val parser = new StaxParser(file)
		parser.parseWithEvents(file)
	}	
}