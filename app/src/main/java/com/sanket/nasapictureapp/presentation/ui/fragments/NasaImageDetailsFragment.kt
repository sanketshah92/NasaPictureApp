package com.sanket.nasapictureapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sanket.nasapictureapp.R
import com.sanket.nasapictureapp.databinding.FragmentNasaImageDetailBinding
import com.sanket.nasapictureapp.presentation.ui.adapters.NasaImageDetailsPagerAdapter
import kotlin.math.abs


class NasaImageDetailsFragment : Fragment() {
    private lateinit var binding: FragmentNasaImageDetailBinding
    private val adapter = NasaImageDetailsPagerAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_nasa_image_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareViewPager()
        val nasaImageData = arguments?.let {
            NasaImageDetailsFragmentArgs.fromBundle(it).imageData
        }
        val startPos = arguments?.let {
            NasaImageDetailsFragmentArgs.fromBundle(it).startPost
        }
        nasaImageData?.let { adapter.updateData(it) }
        startPos?.let { binding.viewPager2.setCurrentItem(it, false) }
    }

    private fun prepareViewPager() {
        binding.viewPager2.adapter = adapter

    }


}