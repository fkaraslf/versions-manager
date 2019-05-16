package dk.kmd.nexus.hcl.versionmanager.web.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dk.kmd.nexus.hcl.versionmanager.domain.EntityId
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper {
        val mapper = ObjectMapper()

        val module = SimpleModule()
        module.addSerializer(EntityId::class.java, EntityIdSerializer())
        mapper.registerModule(module)
        mapper.registerModule(KotlinModule())

        return mapper
    }
}
