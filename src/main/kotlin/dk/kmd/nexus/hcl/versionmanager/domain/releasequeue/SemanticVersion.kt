package dk.kmd.nexus.hcl.versionmanager.domain.releasequeue

data class SemanticVersion(
        val major: Int = 0,
        val minor: Int = 0,
        val patch: Int = 0) { // add suffix

    companion object {

        fun fromString(version: String): SemanticVersion {

            val pattern = Regex("""(0|[1-9]\d*)?(?:\.)?(0|[1-9]\d*)?(?:\.)?(0|[1-9]\d*)""")
            val result = pattern.matchEntire(version) ?: throw IllegalArgumentException("Invalid version string [$version]")

            if (result.groupValues.size != 4 || result.groupValues.any { it.isBlank() }) {
                throw IllegalArgumentException("Invalid version string [$version]")
            }

            return SemanticVersion(
                    major = result.groupValues[1].toInt(),
                    minor = result.groupValues[2].toInt(),
                    patch = result.groupValues[3].toInt()
            )
        }
    }
}

