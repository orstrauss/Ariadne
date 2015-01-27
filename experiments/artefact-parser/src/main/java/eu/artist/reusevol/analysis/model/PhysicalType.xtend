package eu.artist.reusevol.analysis.model

import java.util.ArrayList

@Data
class PhysicalType {
	String name
	String mimetype
	PhysicalType parent
	ArrayList<PhysicalType> subtypes = newArrayList  
	
	def addSubtype(String name, String mimetype) {
		subtypes.add(new PhysicalType(name, mimetype, this))		
	}	
}