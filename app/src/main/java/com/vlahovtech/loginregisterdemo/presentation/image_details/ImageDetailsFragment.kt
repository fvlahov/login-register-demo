package com.vlahovtech.loginregisterdemo.presentation.image_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vlahovtech.loginregisterdemo.base.BaseFragment
import com.vlahovtech.loginregisterdemo.databinding.FragmentImageDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.withCreationCallback

@AndroidEntryPoint
class ImageDetailsFragment : BaseFragment<FragmentImageDetailsBinding>() {

    private val args: ImageDetailsFragmentArgs by navArgs()
    private val viewModel: ImageDetailsViewModel by viewModels(
        extrasProducer = {
            defaultViewModelCreationExtras.withCreationCallback<ImageDetailsViewModel.Factory> { factory ->
                factory.create(pixabayImage = args.pixabayImage)
            }
        }
    )

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentImageDetailsBinding {
        return FragmentImageDetailsBinding.inflate(inflater, container, false)
    }

    override fun initViews(binding: FragmentImageDetailsBinding) {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

}