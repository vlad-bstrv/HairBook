package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.repository.ClientRepository

class GetClientUseCase (
    private val repository: ClientRepository
) {

    suspend operator fun invoke(id: Long): Client {
        return repository.getClientById(id)
    }
}