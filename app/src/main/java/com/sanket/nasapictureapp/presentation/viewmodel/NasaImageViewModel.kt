package com.sanket.nasapictureapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.sanket.nasapictureapp.domain.usecase.GetNasaImageUseCase

class NasaImageViewModel(private val useCase: GetNasaImageUseCase) : ViewModel() {
    suspend fun getNasaImageData() {
        useCase.execute()
    }
}