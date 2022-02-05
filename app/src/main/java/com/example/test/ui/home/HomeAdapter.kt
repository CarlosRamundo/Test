package com.example.test.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.core.BaseViewHolder
import com.example.test.data.model.Device
import com.example.test.data.model.DeviceItem
import com.example.test.databinding.DeviceItemBinding

class HomeAdapter(private val deviceList: Device, private val onClickListener:(DeviceItem)-> Unit) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            DeviceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = HomeViewHolder(itemBinding, parent.context)

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is HomeViewHolder -> holder.bind(deviceList[position], onClickListener)
        }
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    inner class HomeViewHolder(val binding: DeviceItemBinding, val context: Context) :
        BaseViewHolder<DeviceItem>(binding.root) {

        override fun bind(item: DeviceItem) {
            Glide.with(context).load(item.mainImage.url).centerCrop().into(binding.deviceImage)
            binding.deviceName.text = item.name
            binding.installmentsTag.text = item.installmentsTag
            binding.topTag.text = item.topTag
        }

        override fun bind(t: DeviceItem, onClickListener: (DeviceItem) -> Unit) {
            Glide.with(context).load(t.mainImage.url).centerCrop().into(binding.deviceImage)
            binding.deviceName.text = t.name
            binding.installmentsTag.text = t.installmentsTag
            binding.topTag.text = t.topTag
            itemView.setOnClickListener { onClickListener(t)}
        }
    }

}