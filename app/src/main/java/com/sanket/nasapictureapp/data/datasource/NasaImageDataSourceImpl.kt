package com.sanket.nasapictureapp.data.datasource

import com.sanket.nasapictureapp.data.api.ApiService
import com.sanket.nasapictureapp.data.model.NasaImageData
import okhttp3.ResponseBody
import retrofit2.Response

class NasaImageDataSourceImpl( private val service: ApiService) {
    suspend fun getNasaImages(): Response<NasaImageData> =
        service.getNasaImages()
}