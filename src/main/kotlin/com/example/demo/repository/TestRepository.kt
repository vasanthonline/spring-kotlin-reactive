package com.example.demo.repository

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class TestRepository {
    fun findAllByName(documentName: String): Flux<TestDocument> {
        val testDocuments = listOf<TestDocument>(
            TestDocument("1", documentName),
            TestDocument("2", "example $documentName")
        )
        return Flux.fromIterable(testDocuments)
    }
}