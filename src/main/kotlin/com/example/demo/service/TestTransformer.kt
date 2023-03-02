package com.example.demo.service

import com.example.demo.models.TestRecord
import com.example.demo.repository.TestDocument

object TestTransformer {
    fun transform(testDocument: TestDocument): TestRecord {
        return TestRecord(testDocument.name ?: "")
    }
}