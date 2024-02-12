package com.example.barberappointment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.barberappointment.R
import com.example.barberappointment.databinding.FragmentInitBinding

class initFragment : Fragment() {
    private var _binding: FragmentInitBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }


    private fun initClick(){

        binding.btnLogin.setOnClickListener{findNavController().navigate(R.id.action_initFragment_to_loginFragment)

        }
        binding.btnSend.setOnClickListener {
            findNavController().navigate(R.id.action_initFragment_to_registerFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}