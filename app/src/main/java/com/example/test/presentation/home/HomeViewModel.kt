package com.example.test.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.test.core.Result
import com.example.test.repository.HomeRepo
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val repo: HomeRepo):ViewModel() {
    fun fetchDevices() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.getDevices()))
        }catch(e : Exception) {
            emit(Result.Failure(e))
        }
    }
}

class HomeViewModelFactory(private val repo: HomeRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HomeRepo::class.java).newInstance(repo)
    }
}