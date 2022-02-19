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

private const val BASE_API = "https://api.etherscan.io/api"
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
    @GET("?module=account&action=balance&address={address}bae&tag=latest&apikey=YourApiKeyToken")
    fun getBalance(@Path("address")accountAddress: String): Deferred<ApiBalance>
}

object EasyWalletApi {
    val retroFitService: EasyWalletApiService by lazy { retrofit.create(EasyWalletApiService::class.java) }
}