package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.model.Client
import com.example.hairbook.domain.repository.ClientRepository

class UpdateClientUsecase(
    private val repository: ClientRepository
) {

    suspend operator fun invoke(client: Client): Client {
        return repository.updateClient(client)
    }
}