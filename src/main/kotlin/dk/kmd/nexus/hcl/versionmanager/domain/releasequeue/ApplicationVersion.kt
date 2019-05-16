package dk.kmd.nexus.hcl.versionmanager.domain.releasequeue

class ApplicationVersion(
        val semanticVersion: SemanticVersion
) {
    var released: Boolean = false
    var comment: String? = null
}
