package com.sanket.nasapictureapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanket.nasapictureapp.data.model.NasaImageData
import com.sanket.nasapictureapp.domain.usecase.GetNasaImageUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NasaImageViewModel(private val useCase: GetNasaImageUseCase) : ViewModel() {

    fun getNasaImageData()= liveData {
        val nasaImages = useCase.execute()
         emit(nasaImages)
     }
}