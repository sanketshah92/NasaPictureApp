package com.sanket.nasapictureapp.presentation

import android.app.Application
import com.sanket.nasapictureapp.data.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Application: Application() {

    companion object {
        private var BASE_URL = "https://drive.google.com/file/d/18t-LzVG7bxu-oPxJQZg8P49I9UHcA552/"
        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        fun getApiService() : ApiService {
            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}