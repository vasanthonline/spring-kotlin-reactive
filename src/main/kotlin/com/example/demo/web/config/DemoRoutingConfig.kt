package com.example.demo.web.config

import com.example.demo.web.handler.TestRecordHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class DemoRoutingConfig(val testRecordHandler: TestRecordHandler) {
    @Bean
    fun timeslotRouter(): RouterFunction<ServerResponse> {
        return router {
            BASE_URI.nest {
                GET("/test-record")
                    .and(queryParam("name") { it.isNotBlank() })
                    .invoke { testRecordHandler.getTestRecords(it) }
            }
        }
    }

    companion object {
        const val BASE_URI = "/api"
    }
}