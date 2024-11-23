package com.vlahovtech.loginregisterdemo.presentation.register

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.vlahovtech.loginregisterdemo.R
import com.vlahovtech.loginregisterdemo.base.BaseFragment
import com.vlahovtech.loginregisterdemo.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
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
            buttonRegister.setOnClickListener {
                viewModel.onRegisterClicked(
                    email = binding.inputEmail.text?.toString().orEmpty(),
                    password = binding.inputPassword.text?.toString().orEmpty(),
                    age = binding.inputAge.text?.toString().orEmpty().toIntOrNull(),
                )
            }
        }

        lifecycleScope.launch {
            viewModel.effect.collectLatest { effect ->
                when(effect) {
                    RegisterContract.Effect.NavigateToHome -> navigateToHome()
                }
            }
        }
    }


    private fun navigateToHome() {
        findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
    }

}