package com.sanket.nasapictureapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.sanket.nasapictureapp.R
import com.sanket.nasapictureapp.data.datasource.NasaImageDataSourceImpl
import com.sanket.nasapictureapp.data.datasource.NasaImageDetailRepositoryImpl
import com.sanket.nasapictureapp.domain.usecase.GetNasaImageUseCase
import com.sanket.nasapictureapp.presentation.Application
import com.sanket.nasapictureapp.presentation.viewmodel.NasaImageViewModel
import com.sanket.nasapictureapp.presentation.viewmodel.NasaImageViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: NasaImageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createDependency()
    }

    private fun createDependency() {
        val apiService = Application.getApiService()
        val dependencies = NasaImageDetailRepositoryImpl(NasaImageDataSourceImpl(apiService))
        val factory = NasaImageViewModelFactory(GetNasaImageUseCase(dependencies))
        prepareViewModel(factory)
    }

    private fun prepareViewModel(factory: NasaImageViewModelFactory) {
        viewModel =
            ViewModelProvider(this, factory)[NasaImageViewModel::class.java]
    }
}