package com.example.test.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.test.R
import com.example.test.core.Result
import com.example.test.data.model.DeviceItem
import com.example.test.data.remote.HomeDataSource
import com.example.test.databinding.FragmentHomeBinding
import com.example.test.presentation.home.HomeViewModel
import com.example.test.presentation.home.HomeViewModelFactory
import com.example.test.repository.HomeRepoImpl
import com.example.test.repository.RetrofitClent
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val listaImagenes = mutableListOf<CarouselItem>()
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel> {
        HomeViewModelFactory(
            HomeRepoImpl(
                HomeDataSource(RetrofitClent.webservice)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        viewModel.fetchDevices().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvHome.adapter =
                        HomeAdapter(result.data) { deviceSelected -> onClickDevice(deviceSelected) }
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Error ${result.exeption} al cargar los datos!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    fun onClickDevice(deviceSelected: DeviceItem) {
        binding.carrusel.visibility = View.VISIBLE
        for (i: Int in deviceSelected.images.indices) {
            listaImagenes.add(
                CarouselItem(
                    imageUrl = deviceSelected.images[i].url,
                    caption = deviceSelected.legal
                )
            )
        }
        binding.carousel.addData(listaImagenes)
        val constraintLayout: ConstraintLayout = binding.clHome
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(
            R.id.rv_home,
            ConstraintSet.TOP,
            R.id.carrusel,
            ConstraintSet.BOTTOM,
            0
        )
        constraintSet.applyTo(constraintLayout)
        /**PROBANDO ONCLICKDEVICE Y PASANDO DATOS POR SAFEARGS
         * val action = HomeFragmentDirections.actionHomeFragmentToDeviceDetailFragment(
        deviceSelected.name,
        deviceSelected.mainImage.url,
        deviceSelected.installmentsTag,
        deviceSelected.topTag
        )
        findNavController().navigate(action)*/
    }
}
