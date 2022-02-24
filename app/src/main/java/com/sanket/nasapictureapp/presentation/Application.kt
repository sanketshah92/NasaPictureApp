package com.sanket.nasapictureapp.presentation

import android.app.Application
import com.sanket.nasapictureapp.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Application: Application() {

    companion object {
        var BASE_URL = "https://drive.google.com/file/d/18t-LzVG7bxu-oPxJQZg8P49I9UHcA552/view"
        fun create() : ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}