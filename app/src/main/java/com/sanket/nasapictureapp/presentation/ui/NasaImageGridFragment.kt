package com.sanket.nasapictureapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sanket.nasapictureapp.R
import com.sanket.nasapictureapp.databinding.FragmentNasaImageGridBinding
import com.sanket.nasapictureapp.presentation.NasaImageAdapter
import com.sanket.nasapictureapp.presentation.viewmodel.NasaImageViewModel
import com.sanket.nasapictureapp.presentation.viewmodel.NasaImageViewModelFactory

class NasaImageGridFragment : Fragment() {

    lateinit var binding: FragmentNasaImageGridBinding
    private lateinit var photoAdapter: NasaImageAdapter
    private lateinit var viewModel: NasaImageViewModel
    private lateinit var factory: NasaImageViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_nasa_image_grid, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, factory).get(NasaImageViewModel::class.java)
        viewModel.getNasaImageData()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)
        photoAdapter = NasaImageAdapter()
        binding.recyclerView.adapter = photoAdapter
    }
}