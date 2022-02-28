package com.sanket.nasapictureapp.presentation.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sanket.nasapictureapp.R
import com.sanket.nasapictureapp.data.model.NasaImageDataItem
import com.sanket.nasapictureapp.databinding.ImageLayoutBinding

class NasaImageAdapter(private val onImageSelection: ViewHolder.OnImageSelection) :
    RecyclerView.Adapter<NasaImageAdapter.ViewHolder>() {
    private val nasaImageData = mutableListOf<NasaImageDataItem>()
    fun updateData(data: List<NasaImageDataItem>) {
        nasaImageData.clear()
        nasaImageData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ImageLayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.image_layout, parent, false)
        return ViewHolder(binding, onImageSelection)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nasaImageData[position])
    }

    override fun getItemCount(): Int {
        return nasaImageData.size
    }

    class ViewHolder(
        private val binding: ImageLayoutBinding,
        private val onImageSelection: OnImageSelection
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataItem: NasaImageDataItem) {
            binding.ivNasa.setOnClickListener {
                onImageSelection.onImageSelected(dataItem, adapterPosition)
            }
            Glide.with(binding.ivNasa.context).load(dataItem.url)
                .centerCrop()
                .override(200,200)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivNasa)
        }

        interface OnImageSelection {
            fun onImageSelected(item: NasaImageDataItem, pos: Int)
        }
    }
}