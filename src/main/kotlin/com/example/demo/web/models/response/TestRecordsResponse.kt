package com.example.demo.web.models.response

import com.example.demo.models.TestRecord

data class TestRecordsResponse(
    val testRecords: List<TestRecord>
)

fun toTestRecordsResponse(testRecords: List<TestRecord>): TestRecordsResponse {
    return TestRecordsResponse(testRecords)
}