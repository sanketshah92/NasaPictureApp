package com.sanket.nasapictureapp.data.datasource

import com.sanket.nasapictureapp.data.model.NasaImageData
import com.sanket.nasapictureapp.domain.repository.NasaImageDetailRepository

class NasaImageDetailRepositoryImpl(private val dataSource: NasaImageDataSourceImpl) :
    NasaImageDetailRepository {
    override suspend fun getImageData(): NasaImageData {
        return dataSource.getNasaImages()
    }
}