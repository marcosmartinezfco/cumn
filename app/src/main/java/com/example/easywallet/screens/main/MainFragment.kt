package com.example.easywallet.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.easywallet.R
import com.example.easywallet.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.mainButton.setOnClickListener{
            val wallet = binding.textInputCartera.text?.toString()
            if (wallet != null){
                val action = MainFragmentDirections.actionMainFragmentToTransactionsFragment(wallet)
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
        return binding.root
    }
}