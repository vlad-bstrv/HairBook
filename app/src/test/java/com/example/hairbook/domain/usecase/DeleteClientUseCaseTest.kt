package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.model.Client
import com.example.hairbook.domain.exception.InvalidClientException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class DeleteClientUseCaseTest {

    private val testRepository = TestRepository()
    private val useCase = DeleteClientUseCase(repository = testRepository)

    @Test
    fun testDeleteClientSuccessful() = runTest {

        val expected = Client(
            id = 1L,
            firstName = "Vladislav",
            lastName = "Bystrov",
            phoneNumber = "+79998884444",
            comment = ""
        )

        val actual = try {
            useCase.invoke(expected)
        } catch (e: InvalidClientException) {
            e.message.toString()
        }

        assertEquals(expected, actual)
    }
}