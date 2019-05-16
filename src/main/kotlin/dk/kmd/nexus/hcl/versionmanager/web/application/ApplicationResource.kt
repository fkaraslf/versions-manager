package dk.kmd.nexus.hcl.versionmanager.web.application

import dk.kmd.nexus.hcl.versionmanager.domain.application.ApplicationId

data class ApplicationResource (
        val id: ApplicationId,
        val name: String
)
