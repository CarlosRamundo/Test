package com.example.test.repository

import com.example.test.data.model.Device
import com.example.test.data.remote.HomeDataSource

class HomeRepoImpl(private val dataSource: HomeDataSource): HomeRepo {
    override suspend fun getDevices(): Device = dataSource.getDevices()
}