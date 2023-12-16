package com.example.hairbook.domain.usecase

import com.example.hairbook.domain.entity.Client
import com.example.hairbook.domain.exception.InvalidClientException
import com.example.hairbook.domain.repository.ClientRepository
import com.example.hairbook.domain.util.isValidPhoneNumber

class AddClientUseCase(
    private val repository: ClientRepository
) {

    @Throws(InvalidClientException::class)
    suspend operator fun invoke(client: Client): Client {
        if(client.firstName.isBlank()) {
            throw InvalidClientException("The first name of the client can't be empty")
        }

        if (!client.phoneNumber.isValidPhoneNumber()) {
            throw InvalidClientException("Phone number is not correct")
        }

        return repository.insertClient(client)
    }
}