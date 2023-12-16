package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.exception.InvalidClientException
import com.example.hairbook.domain.repository.ClientRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals


class TestRepository : ClientRepository {
    override suspend fun getClients(): List<Client> {
        TODO("Not yet implemented")
    }

    override suspend fun getClientById(clientId: Long): Client {
        return Client(
            id = 1L,
            firstName = "Vladislav",
            lastName = "Bystrov",
            phoneNumber = "+79112358096",
            comment = ""
        )
    }

    override suspend fun insertClient(client: Client): Client {
        return client
    }

    override suspend fun deleteClient(client: Client): Client {
        return client
    }

    override suspend fun updateClient(client: Client): Client {
        return client
    }

}

class AddClientUseCaseTest {

    private val testRepository = TestRepository()
    private val useCase = AddClientUseCase(repository = testRepository)
    @Test
    fun testShouldExceptionWithEmptyFirstNameClient() = runTest {

        val client = Client(
            id = 1L,
            firstName = "",
            lastName = "Bystrov",
            phoneNumber = "+79112358096",
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
            firstName = "Vladislav",
            lastName = "Bystrov",
            phoneNumber = "79112358096",
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
            phoneNumber = "+79112358096",
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