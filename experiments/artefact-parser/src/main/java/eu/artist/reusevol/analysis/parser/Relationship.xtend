package eu.artist.reusevol.analysis.parser

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors @ToString @EqualsHashCode
class Relationship {
	val Representation source
	val Representation target
	val String type
}