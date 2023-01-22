package cz.mendelu.ja.project3.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfig {

    @Bean
    fun httpApi(): GroupedOpenApi = GroupedOpenApi
        .builder()
        .group("http")
        .pathsToMatch("/**")
        .build()

    @Bean
    fun springShopOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Dance Studio API")
                    .description("Dance Studio Application Documentation")
                    .version("0.0.1")
            )
    }

}