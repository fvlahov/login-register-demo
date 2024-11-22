package com.vlahovtech.loginregisterdemo.presentation.register

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vlahovtech.loginregisterdemo.base.BaseFragment
import com.vlahovtech.loginregisterdemo.databinding.FragmentLoginBinding
import com.vlahovtech.loginregisterdemo.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val viewModel: RegisterViewModel by viewModels()

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentRegisterBinding {
        return FragmentRegisterBinding.inflate(inflater, container, false)
    }

    override fun initViews(binding: FragmentRegisterBinding) {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.apply {
            toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
            buttonRegister.setOnClickListener { viewModel.onLoginClicked() }
        }
    }


    private fun navigateToRegister() {
        //findNavController().navigate()
    }

}