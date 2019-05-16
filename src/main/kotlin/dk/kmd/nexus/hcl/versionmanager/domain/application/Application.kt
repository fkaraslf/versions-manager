package dk.kmd.nexus.hcl.versionmanager.domain.application

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "applications")
data class Application(
        @Id val id: ApplicationId,
        @Indexed(unique = true) val name: String
)
