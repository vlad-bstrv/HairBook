package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.exception.InvalidClientException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class UpdateClientUsecaseTest{

    private val testRepository = TestRepository()
    private val useCase = UpdateClientUsecase(repository = testRepository)

    @Test
    fun testUpdateClientSuccessful() = runTest {

        val expected = Client(
            id = 1L,
            firstName = "Vladislav",
            lastName = "Bystrov",
            phoneNumber = "+79998884444",
            comment = ""
        )

        val actual = try {
            useCase.invoke(client = expected)
        } catch (e: InvalidClientException) {
            e.message.toString()
        }

        assertEquals(expected, actual)
    }
}