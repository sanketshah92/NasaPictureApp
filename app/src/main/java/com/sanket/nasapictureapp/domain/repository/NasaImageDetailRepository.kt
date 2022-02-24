package com.sanket.nasapictureapp.domain.repository

import com.sanket.nasapictureapp.data.model.NasaImageData

interface NasaImageDetailRepository {
    suspend fun getImageData(): NasaImageData
}