package dk.kmd.nexus.hcl.versionmanager.domain.releasequeue

import dk.kmd.nexus.hcl.versionmanager.domain.application.ApplicationId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ReleaseQueueRepository : MongoRepository<ReleaseQueue, Long> {

    fun findByApplicationId(applicationId: ApplicationId): Optional<ReleaseQueue>
}
