package com.example.dogedex.auth

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import com.example.dogedex.R
import com.example.dogedex.databinding.FragmentSignUpBinding
import com.example.dogedex.isValidEmail


class SignUpFragment : Fragment() {

    interface SignUpFragmentActions{
        fun onSignUpFieldsValidated(email: String,password:String,passwordConfirmation: String)
    }
    private lateinit var signUpFragmentActions: SignUpFragmentActions

    override fun onAttach(context: Context) {
        super.onAttach(context)
        signUpFragmentActions = try {
            context as SignUpFragmentActions
        }catch(e: ClassCastException){
            throw ClassCastException("$context must implement loginFragmentActions")
        }
    }


    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentSignUpBinding.inflate(inflater)
        seturSignUpButton()
        return binding.root
    }

    private fun seturSignUpButton() {
        binding.signUpButton.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        binding.emailInput.error=""
        binding.passwordInput.error=""
        binding.confirmPasswordInput.error=""

        val email = binding.emailEdit.text.toString()

        if (!isValidEmail(email)) {
            binding.emailInput.error = getString(R.string.email_is_not_valid)
            return
        }
        val password = binding.passwordEdit.text.toString()
        if (password.isEmpty()) {
            binding.passwordInput.error = getString(R.string.password_must_not_be_empty)
            return
        }
        val passwordConfirmation = binding.confirmPasswordEdit.text.toString()
        if (passwordConfirmation.isEmpty()) {
            binding.confirmPasswordInput.error = getString(R.string.password_must_not_be_empty)
            return
        }
        if(password != passwordConfirmation){
            binding.passwordInput.error = getString(R.string.passwords_do_not_match)
            return
        }

        signUpFragmentActions.onSignUpFieldsValidated(email,password, passwordConfirmation)
    }


}