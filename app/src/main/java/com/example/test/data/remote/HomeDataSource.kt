package com.example.test.data.remote

import com.example.test.data.model.Device
import com.example.test.repository.WebService

class HomeDataSource(private val webService: WebService) {
    suspend fun getDevices(): Device = webService.getDevices()
}