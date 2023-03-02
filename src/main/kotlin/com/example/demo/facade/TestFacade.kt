package com.example.demo.facade

import com.example.demo.models.TestRecord
import com.example.demo.service.TestService
import com.example.demo.service.TestTransformer
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class TestFacade(private val testService: TestService) {
    fun getTestRecordsByName(recordName: String): Mono<List<TestRecord>> {
        return testService.findTestDocumentsByName(recordName)
            .map { TestTransformer.transform(it) }
            .collectList()
    }
}