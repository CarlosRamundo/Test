package com.example.test.repository

import com.example.test.data.model.Device

interface HomeRepo {
    suspend fun getDevices():Device
}