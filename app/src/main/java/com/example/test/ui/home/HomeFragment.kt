package com.example.test.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.test.R
import com.example.test.core.Result
import com.example.test.data.remote.HomeDataSource
import com.example.test.databinding.FragmentHomeBinding
import com.example.test.presentation.home.HomeViewModel
import com.example.test.presentation.home.HomeViewModelFactory
import com.example.test.repository.HomeRepoImpl
import com.example.test.repository.RetrofitClent

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel> {HomeViewModelFactory(HomeRepoImpl(
        HomeDataSource(RetrofitClent.webservice)
    ))  }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        viewModel.fetchDevices().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Result.Loading->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success->{
                    binding.progressBar.visibility = View.GONE
                    Log.d("result", "${result.data}")

                }
                is Result.Failure->{
                    binding.progressBar.visibility = View.GONE
                    Log.d("result", "falló petición ${result.exeption}")
                }
            }
        })
    }
}