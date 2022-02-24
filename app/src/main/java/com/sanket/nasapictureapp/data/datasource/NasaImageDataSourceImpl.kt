package com.sanket.nasapictureapp.data.datasource

import com.sanket.nasapictureapp.data.api.ApiService
import com.sanket.nasapictureapp.data.model.NasaImageData
import retrofit2.Response

class NasaImageDataSourceImpl( private val service: ApiService) {
    suspend fun getNasaImages(): NasaImageData =
        service.getNasaImages()
}