package dk.kmd.nexus.hcl.versionmanager.web.releasequeue

import dk.kmd.nexus.hcl.versionmanager.domain.application.ApplicationId
import dk.kmd.nexus.hcl.versionmanager.domain.application.ApplicationRepository
import dk.kmd.nexus.hcl.versionmanager.domain.releasequeue.ReleaseQueue
import dk.kmd.nexus.hcl.versionmanager.domain.releasequeue.ReleaseQueueRepository
import dk.kmd.nexus.hcl.versionmanager.domain.releasequeue.SemanticVersion
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

private val logger = KotlinLogging.logger {}

@RequestMapping("/releasequeues")
@RestController
class ReleaseQueueController(
        private val applicationRepository: ApplicationRepository,
        private val releaseQueueRepository: ReleaseQueueRepository
) {

    @GetMapping
    fun fetchAllReleaseQueues(): List<ReleaseQueue> {
        return releaseQueueRepository.findAll()
    }

    @GetMapping("/{applicationId}")
    fun fetchReleaseQueueForApplication(@PathVariable applicationId: ApplicationId): ReleaseQueue {
        logger.info { "Fetch release queue for application with id $applicationId" }

        return releaseQueueRepository.findByApplicationId(applicationId)
                .orElseThrow { RuntimeException("404") }
    }

    @PutMapping("/{applicationId}/versions")
    fun fetchReleaseQueueForApplication(@PathVariable applicationId: ApplicationId, @RequestBody resource: SemanticVersionResource): ReleaseQueue {
        logger.info { "Fetch release queue for application with id $applicationId" }

        val semanticVersion = SemanticVersion.fromString(resource.version)
        val releaseQueue = releaseQueueRepository.findByApplicationId(applicationId)
                .orElseThrow { RuntimeException("404") }

        releaseQueue.addVersion(semanticVersion)
        releaseQueueRepository.save(releaseQueue)

        return releaseQueueRepository.findByApplicationId(applicationId)
                .orElseThrow { RuntimeException("404") }
    }
}
