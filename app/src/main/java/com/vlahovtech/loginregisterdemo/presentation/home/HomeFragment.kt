package com.vlahovtech.loginregisterdemo.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.vlahovtech.loginregisterdemo.R
import com.vlahovtech.loginregisterdemo.base.BaseFragment
import com.vlahovtech.loginregisterdemo.databinding.FragmentHomeBinding
import com.vlahovtech.loginregisterdemo.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

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
            buttonRegister.setOnClickListener { navigateToRegister() }
            buttonLogin.setOnClickListener {
                viewModel.onLoginClicked(
                    email = binding.inputEmail.text?.toString().orEmpty(),
                    password = binding.inputPassword.text?.toString().orEmpty()
                )
            }
        }

        lifecycleScope.launch {
            viewModel.effect.collectLatest { effect ->
                when(effect) {
                    HomeContract.Effect.NavigateToHome -> navigateToHome()
                }
            }
        }
    }


    private fun navigateToRegister() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun navigateToHome() {
        //TODO: findNavController().navigate()
    }

}