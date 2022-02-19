package com.example.easywallet.screens.transactions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.easywallet.R
import com.example.easywallet.databinding.FragmentMainBinding
import com.example.easywallet.databinding.FragmentTransactionsBinding

class TransactionsFragment : Fragment() {
    private val args:TransactionsFragmentArgs by navArgs()

    private val viewModel: TransactionsViewModel by lazy {
        val activity = requireNotNull(this.activity)
        ViewModelProvider(this, TransactionsViewModelFactory(activity.application))
            .get(TransactionsViewModel::class.java)
    }

    private lateinit var binding: FragmentTransactionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_transactions, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = TransactionAdapter()
        binding.transactionsList.adapter = adapter
        return binding.root
    }
}