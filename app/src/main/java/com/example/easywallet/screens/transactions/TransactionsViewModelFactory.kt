package com.example.easywallet.screens.transactions

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TransactionsViewModelFactory(private val application: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionsViewModel::class.java))
            return TransactionsViewModel(application) as T
        else
            throw IllegalArgumentException()
    }
}