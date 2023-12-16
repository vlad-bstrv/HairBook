package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.repository.ClientRepository

class GetClientsUseCase (
    private val repository: ClientRepository
) {

    suspend operator fun invoke(): List<Client> {
        return repository.getClients()
    }
}