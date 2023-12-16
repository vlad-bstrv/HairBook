package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.repository.ClientRepository

class DeleteClientUseCase(
    private val repository: ClientRepository
) {

    suspend operator fun invoke(client: Client): Client {
        return repository.deleteClient(client)
    }
}