package com.example.test.ui.device

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.databinding.FragmentDeviceDetailBinding

class DeviceDetailFragment : Fragment(R.layout.fragment_device_detail) {

    private val args by navArgs<DeviceDetailFragmentArgs>()
    private lateinit var binding: FragmentDeviceDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDeviceDetailBinding.bind(view)
        Glide.with(requireContext()).load(args.deviceImageUrl).centerCrop().into(binding.deviceImage)
        binding.deviceName.text = args.deviceName
        binding.installmentsTag.text = args.installmentsTag
        binding.topTag.text = args.topTag
    }
}