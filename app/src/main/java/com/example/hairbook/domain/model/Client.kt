package com.example.hairbook.domain.model

data class Client(
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val comment: String
)


