package com.example.cryptocurrency.domain

data class Status(
    val timestamp: String,
    val error_code: Int,
    val error_message: String?
)