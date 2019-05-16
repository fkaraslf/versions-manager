package dk.kmd.nexus.hcl.versionmanager.domain.application

import dk.kmd.nexus.hcl.versionmanager.domain.EntityId
import java.util.*

class ApplicationId: EntityId {
    constructor() : super()
    constructor(uuid: UUID) : super(uuid)
}

