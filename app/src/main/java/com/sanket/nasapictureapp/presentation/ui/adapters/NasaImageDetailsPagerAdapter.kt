package com.sanket.nasapictureapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sanket.nasapictureapp.R
import com.sanket.nasapictureapp.data.model.NasaImageData
import com.sanket.nasapictureapp.data.model.NasaImageDataItem
import com.sanket.nasapictureapp.databinding.ItemNasaItemDetailBinding

class NasaImageDetailsPagerAdapter :
    RecyclerView.Adapter<NasaImageDetailsPagerAdapter.ViewHolder>() {
    private val nasaImageData = mutableListOf<NasaImageDataItem>()
    fun updateData(data: Array<NasaImageDataItem>) {
        nasaImageData.clear()
        nasaImageData.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemNasaItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NasaImageDataItem) {
            binding.textViewTitle.text = data.title
            binding.textViewDescription.text = data.explanation
            Glide.with(binding.imageView.context).load(data.hdurl)
                .centerCrop()
                .override(200, 200)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemNasaItemDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_nasa_item_detail, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(nasaImageData[position])
    }

    override fun getItemCount(): Int {
        return nasaImageData.size
    }
}