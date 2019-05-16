package dk.kmd.nexus.hcl.versionmanager.domain.releasequeue

import dk.kmd.nexus.hcl.versionmanager.domain.application.ApplicationId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "release-queues")
data class ReleaseQueue(
        @Id val id: UUID = UUID.randomUUID(),
        val applicationId: ApplicationId,
        val versions: MutableList<ApplicationVersion> = mutableListOf()
) {
    fun addVersion(semanticVersion: SemanticVersion) {
        versions.add(ApplicationVersion(semanticVersion))
    }
}
