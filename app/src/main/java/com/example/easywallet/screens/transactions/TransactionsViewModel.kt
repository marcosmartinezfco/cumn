package com.example.easywallet.screens.transactions

import android.app.Application
import android.os.Debug
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easywallet.repository.EasyWalletRepository
import kotlinx.coroutines.launch

class TransactionsViewModel(address: String, application: Application) : AndroidViewModel(application) {
    private val repository = EasyWalletRepository()
    val balance =  Transformations.map(repository.balance){
        it
    }
    val transactions = repository.transactions

    init {
        viewModelScope.launch {
            repository.fetchAccountBalance(address)
            repository.fetchTransactions(address)
        }
    }
}