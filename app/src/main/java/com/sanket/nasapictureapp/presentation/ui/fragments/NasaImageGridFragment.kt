package com.sanket.nasapictureapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sanket.nasapictureapp.R
import com.sanket.nasapictureapp.data.model.NasaImageData
import com.sanket.nasapictureapp.data.model.NasaImageDataItem
import com.sanket.nasapictureapp.databinding.FragmentNasaImageGridBinding
import com.sanket.nasapictureapp.presentation.ui.MainActivity
import com.sanket.nasapictureapp.presentation.ui.adapters.NasaImageAdapter
import com.sanket.nasapictureapp.presentation.viewmodel.NasaImageViewModel

class NasaImageGridFragment : Fragment(), NasaImageAdapter.ViewHolder.OnImageSelection {

    private lateinit var binding: FragmentNasaImageGridBinding
    private lateinit var photoAdapter: NasaImageAdapter
    private lateinit var viewModel: NasaImageViewModel
    private val nasaImageData: NasaImageData = NasaImageData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_nasa_image_grid, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        viewModel = (activity as MainActivity).viewModel
        viewModel.getNasaImageData().observe(viewLifecycleOwner, Observer { it ->
            it.sortedWith(compareBy { item -> item.date })
            nasaImageData.addAll(it)
            if (::photoAdapter.isInitialized) {
                photoAdapter.updateData(it)
                photoAdapter.notifyDataSetChanged()
            }
        })

    }

    private fun setUpRecyclerView() {
        photoAdapter = NasaImageAdapter(this)
        binding.recyclerView.adapter = photoAdapter
    }

    override fun onImageSelected(item: NasaImageDataItem, pos: Int) {
        val action =
            NasaImageGridFragmentDirections.actionNasaImageGridFragmentToNasaImageDetailsFragment(
                nasaImageData.toTypedArray(),
                pos
            )
        findNavController().navigate(action)
    }

}