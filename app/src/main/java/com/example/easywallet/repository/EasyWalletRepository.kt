package com.example.easywallet.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.easywallet.network.EasyWalletApi
import com.example.easywallet.network.EasyWalletApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.lang.Exception

class EasyWalletRepository {
    val balance: MutableLiveData<String> = MutableLiveData("")

    suspend fun fetchAccountBalance(account: String){
        Log.i("Debug1", account)
        withContext(Dispatchers.IO){
            try{
                val balance_result = EasyWalletApi.retroFitService.getBalance(account).await()
                Log.i("Debug2", balance_result.status)
                balance.postValue(balance_result.result)
            }catch(e: Exception){
                Log.e("Error", e.toString())
            }
        }
    }
}