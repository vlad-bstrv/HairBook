package com.example.hairbook.domain.repository

import com.example.hairbook.domain.entity.Client

interface ClientRepository {

    suspend fun getClients(): List<Client>

    suspend fun getClientById(clientId: Long): Client

    suspend fun insertClient(client: Client): Client

    suspend fun deleteClient(client: Client): Client

    suspend fun updateClient(client: Client): Client
}