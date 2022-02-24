package com.sanket.nasapictureapp.domain.usecase

import com.sanket.nasapictureapp.domain.repository.NasaImageDetailRepository

class GetNasaImageUseCase(private val repository: NasaImageDetailRepository) {
    suspend fun execute() =
        repository.getImageData()
}