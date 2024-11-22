package com.vlahovtech.loginregisterdemo.presentation.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.vlahovtech.loginregisterdemo.R
import com.vlahovtech.loginregisterdemo.base.BaseFragment
import com.vlahovtech.loginregisterdemo.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override fun provideBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun initViews(binding: FragmentLoginBinding) {
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
                    LoginContract.Effect.NavigateToHome -> navigateToHome()
                }
            }
        }
    }


    private fun navigateToRegister() {
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private fun navigateToHome() {
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

}