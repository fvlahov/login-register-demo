package com.vlahovtech.loginregisterdemo.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.vlahovtech.domain.model.PixabayImage
import com.vlahovtech.loginregisterdemo.base.BaseFragment
import com.vlahovtech.loginregisterdemo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    private val pixabayImageAdapter = PixabayImageAdapter(onImageClicked = ::navigateToImageDetails)

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initViews(binding: FragmentHomeBinding) {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.apply {
            recyclerImages.adapter = pixabayImageAdapter
        }

        lifecycleScope.launch {
            viewModel.imagesPagingDataFlow.collectLatest { images ->
                pixabayImageAdapter.submitData(images)
            }
        }
    }

    private fun navigateToImageDetails(image: PixabayImage) {
        //TODO: findNavController().navigate()
    }

}