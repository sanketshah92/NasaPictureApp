package com.sanket.nasapictureapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanket.nasapictureapp.domain.usecase.GetNasaImageUseCase

class NasaImageViewModelFactory(val useCase: GetNasaImageUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NasaImageViewModel(useCase) as T
    }
}