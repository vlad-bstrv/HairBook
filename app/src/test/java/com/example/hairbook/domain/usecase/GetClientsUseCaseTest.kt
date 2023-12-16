package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.exception.InvalidClientException
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class GetClientsUseCaseTest {
    private val repository = TestRepository()
    private val useCase = GetClientsUseCase(repository)

    @Test
    fun testGetClientSuccessful() = runTest {

        val expected = listOf(
            Client(
                id = 1L,
                firstName = "Vladislav",
                lastName = "Bystrov",
                phoneNumber = "+79998884444",
                comment = ""
            )
        )

        val actual = try {
            useCase.invoke()
        } catch (e: InvalidClientException) {
            e.message.toString()
        }

        assertEquals(expected, actual)
    }
}