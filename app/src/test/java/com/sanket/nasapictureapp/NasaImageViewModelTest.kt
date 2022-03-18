package com.sanket.nasapictureapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.sanket.nasapictureapp.data.api.ApiService
import com.sanket.nasapictureapp.data.model.NasaImageData
import com.sanket.nasapictureapp.domain.repository.NasaImageDetailRepository
import com.sanket.nasapictureapp.domain.usecase.GetNasaImageUseCase
import com.sanket.nasapictureapp.presentation.viewmodel.NasaImageViewModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NasaImageViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiInterface: ApiService


    lateinit var useCase: GetNasaImageUseCase

    private lateinit var viewModel: NasaImageViewModel

    @Mock
    lateinit var liveData: LiveData<NasaImageData>

    @Mock
    lateinit var repository: NasaImageDetailRepository

    @Before
    fun setup() {
        useCase = GetNasaImageUseCase(repository)
        viewModel = NasaImageViewModel(useCase)
    }

    @Test
    fun when_get_response_from_api_then_return_success() {
        val result = viewModel.getNasaImageData()
        assertNotNull(result)
    }

}