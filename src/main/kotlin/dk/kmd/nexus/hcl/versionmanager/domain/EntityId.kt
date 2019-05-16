package dk.kmd.nexus.hcl.versionmanager.domain

import java.util.*

open class EntityId protected constructor(var uuid: UUID = UUID.randomUUID()) {

    protected constructor(uuid: String) : this(UUID.fromString(uuid))

}
