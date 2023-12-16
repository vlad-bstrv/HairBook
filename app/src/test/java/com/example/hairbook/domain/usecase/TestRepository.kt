package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.repository.ClientRepository

class TestRepository : ClientRepository {
    override suspend fun getClients(): List<Client> {
        return listOf(
            Client(
                id = 1L,
                firstName = "Vladislav",
                lastName = "Bystrov",
                phoneNumber = "+79998884444",
                comment = ""
            )
        )
    }

    override suspend fun getClientById(clientId: Long): Client {
        return Client(
            id = 1L,
            firstName = "Vladislav",
            lastName = "Bystrov",
            phoneNumber = "+79998884444",
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