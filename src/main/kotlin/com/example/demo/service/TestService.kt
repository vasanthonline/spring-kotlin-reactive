package com.example.demo.service

import com.example.demo.repository.TestDocument
import com.example.demo.repository.TestRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class TestService(private val testRepository: TestRepository) {
    fun findTestDocumentsByName(documentName: String): Flux<TestDocument> {
        return testRepository.findAllByName(documentName)
    }
}