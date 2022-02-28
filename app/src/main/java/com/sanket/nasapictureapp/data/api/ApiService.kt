package com.sanket.nasapictureapp.data.api

import com.sanket.nasapictureapp.data.model.NasaImageData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getNasaImages(): Response<NasaImageData>
}