package com.example.giveawayapp.itemOperations.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DonationsApiClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://private-15a842-new4u.apiary-mock.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ApiInterface::class.java)

//    init{
//
//        val builder = Retrofit.Builder()
//        .baseUrl("https://private-15a842-new4u.apiary-mock.com/")
//        .addConverterFactory(GsonConverterFactory
//            .create())
//        .addCallAdapterFactory(CoroutineCallAdapterFactory())

//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

//        val okHttpClient = OkHttpClient.Builder()
////            .addInterceptor(loggingInterceptor)
////            .writeTimeout(0, TimeUnit.MICROSECONDS)
////            .writeTimeout(2,TimeUnit.MINUTES)
////            .writeTimeout(1,TimeUnit.MINUTES)
//            .build()
//Avoid using the Retrofit client() method, as it faces a compile error. I wish they'd fix this
//        retrofit = builder.client(okHttpClient).build()

//    }
//
//    fun getDonationService():ApiInterface {
//        return retrofit.create(ApiInterface::class.java)
//    }
}