package dk.kmd.nexus.hcl.versionmanager.domain.application

import org.springframework.data.mongodb.repository.MongoRepository

interface ApplicationRepository: MongoRepository<Application, ApplicationId>
