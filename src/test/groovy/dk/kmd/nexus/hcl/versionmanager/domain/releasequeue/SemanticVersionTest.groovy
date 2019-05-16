package dk.kmd.nexus.hcl.versionmanager.domain.releasequeue

import spock.lang.Specification
import spock.lang.Unroll

class SemanticVersionTest extends Specification {

	@Unroll
	def "should parse version #versionToParse"() {
		when:
		def parsedVersion = SemanticVersion.@Companion.fromString(versionToParse)

		then:
		parsedVersion.major == major
		parsedVersion.minor == minor
		parsedVersion.patch == patch

		where:
		versionToParse | major | minor | patch
		'0.0.0'        | 0     | 0     | 0
		'1.2.3'        | 1     | 2     | 3
	}

	@Unroll
	def "should not parse version #versionToParse"() {
		when:
		SemanticVersion.@Companion.fromString(versionToParse)

		then:
		thrown(IllegalArgumentException)

		where:
		versionToParse << ['0', '0.0', '0.0.', '.1.2.3', '1.2.3.', '0-0-0', '0.0.0-suffix']
	}
}
