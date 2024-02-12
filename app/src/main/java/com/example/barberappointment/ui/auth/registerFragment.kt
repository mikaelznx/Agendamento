package com.example.barberappointment.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.barberappointment.R
import com.example.barberappointment.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class registerFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private var user = Firebase.auth.currentUser
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            auth = Firebase.auth
            user = Firebase.auth.currentUser
            initClick()
        }

        private fun initClick() {



            binding.btnSend.setOnClickListener {validateData()
            }

        }

        private fun validateData() {
            val email = binding.editEmail.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            if (email.isNotEmpty()) {
                if (password.isNotEmpty()) {
                    registerUser(email, password)
                } else {
                    Toast.makeText(requireContext(), "Informe sua senha.", Toast.LENGTH_SHORT)
                        .show()
                }

            } else {
                Toast.makeText(requireContext(), "Informe seu email.", Toast.LENGTH_SHORT).show()
            }
        }


    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    user!!.sendEmailVerification()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Algum erro aconteceu, tente novamente.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

    }

        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }


    }