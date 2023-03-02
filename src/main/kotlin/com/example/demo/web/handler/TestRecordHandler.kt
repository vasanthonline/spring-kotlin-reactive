package com.example.demo.web.handler

import com.example.demo.facade.TestFacade
import com.example.demo.web.models.response.TestRecordsResponse
import com.example.demo.web.models.response.toTestRecordsResponse
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import org.springframework.http.MediaType.APPLICATION_JSON

@Component
class TestRecordHandler(private val testFacade: TestFacade) {

    fun getTestRecords(serverRequest: ServerRequest): Mono<ServerResponse> {
        val recordName = getQueryParams(serverRequest)

        val bodyMono = testFacade.getTestRecordsByName(recordName)
            .map { toTestRecordsResponse(it) }

        return ok()
            .contentType(APPLICATION_JSON)
            .body(bodyMono, TestRecordsResponse::class.java)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(TestRecordHandler::class.java)

        private fun getQueryParams(serverRequest: ServerRequest): String {
            return serverRequest.queryParam("name")
                .orElse("")
        }
    }
}