package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.exception.InvalidClientException
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals


class AddClientUseCaseTest {

    private val testRepository = TestRepository()
    private val useCase = AddClientUseCase(repository = testRepository)
    @Test
    fun testShouldExceptionWithEmptyFirstNameClient() = runTest {

        val client = Client(
            id = 1L,
            firstName = "",
            lastName = "Ivanov",
            phoneNumber = "+79998884444",
            comment = ""
        )

        val expected = "The first name of the client can't be empty"

        val actual = try {
            useCase.invoke(client)
        } catch (e: InvalidClientException) {
            e.message.toString()
        }

        assertEquals(expected, actual)
    }

    @Test
    fun testShouldExceptionWithInvalidPhoneNumberClient() = runTest {

        val client = Client(
            id = 1L,
            firstName = "Ivan",
            lastName = "Ivanov",
            phoneNumber = "79998884444",
            comment = ""
        )

        val expected = "Phone number is not correct"

        var actual = try {
            useCase.invoke(client)
        } catch (e: InvalidClientException) {
            e.message.toString()
        }

        assertEquals(expected, actual)
    }

    @Test
    fun testInsertClientSuccessful() = runTest {

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