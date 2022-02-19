package com.example.easywallet.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_API = "https://api.etherscan.io/"
private const val API_KEY = "QF6QRKS31TYE54YAABA4S37VJ2V8PWQY8V"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
private val client = OkHttpClient.Builder().addInterceptor(logger).build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_API)
    .client(client)
    .build()

interface EasyWalletApiService {
    @GET("api?module=account&action=balance&tag=latest&apikey=$API_KEY")
    fun getBalance(@Query("address")accountAddress: String): Deferred<ApiBalance>

    @GET("api?module=account&action=txlist&startblock=0&endblock=99999999&page=1&offset=10&sort=asc&apikey=$API_KEY")
    fun getTransactions(@Query("address")accountAddress: String): Deferred<ApiTransactionsContainer>
}

object EasyWalletApi {
    val retroFitService: EasyWalletApiService by lazy { retrofit.create(EasyWalletApiService::class.java) }
}