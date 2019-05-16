package dk.kmd.nexus.hcl.versionmanager.web.application

import dk.kmd.nexus.hcl.versionmanager.domain.application.Application
import dk.kmd.nexus.hcl.versionmanager.domain.application.ApplicationId
import dk.kmd.nexus.hcl.versionmanager.domain.application.ApplicationRepository
import dk.kmd.nexus.hcl.versionmanager.domain.releasequeue.ReleaseQueue
import dk.kmd.nexus.hcl.versionmanager.domain.releasequeue.ReleaseQueueRepository
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*

private val logger = KotlinLogging.logger {}

@RequestMapping("/applications")
@RestController
class ApplicationController(
        private val applicationRepository: ApplicationRepository,
        private val releaseQueueRepository: ReleaseQueueRepository
) {

    @GetMapping
    fun fetchAllApplications(): List<ApplicationResource> {
        return applicationRepository.findAll()
                .map { toResource(it) }
    }

    private fun toResource(it: Application) = ApplicationResource(it.id, it.name)

    @PostMapping
    fun registerApplication(@RequestBody resource: RegisterApplicationResource): ApplicationResource {
        logger.info { "Register application: $resource" }

        val application = Application(ApplicationId(), resource.name)
        applicationRepository.save(application)
        releaseQueueRepository.save(ReleaseQueue(applicationId = application.id))

        return applicationRepository.findById(application.id)
                .map { toResource(it) }
                .orElseThrow { RuntimeException("Cannot fetch saved application") }
    }

}
