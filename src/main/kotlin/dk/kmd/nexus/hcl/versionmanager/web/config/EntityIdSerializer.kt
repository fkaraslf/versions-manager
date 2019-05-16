package dk.kmd.nexus.hcl.versionmanager.web.config

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import dk.kmd.nexus.hcl.versionmanager.domain.EntityId

class EntityIdSerializer: StdSerializer<EntityId>(EntityId::class.java) {

    override fun serialize(value: EntityId, jsonGenerator: JsonGenerator, provider: SerializerProvider) {
        jsonGenerator.writeString(value.uuid.toString())
    }

}
