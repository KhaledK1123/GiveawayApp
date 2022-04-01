package com.example.giveawayapp.itemOperations

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RichardsRetrofitHelper {

    private val retrofit: Retrofit

    init{
        val builder = Retrofit.Builder()
            .baseUrl("https://private-15a842-new4u.apiary-mock.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        val loggingInterceptor = HttpLoggingInterceptor()

        //boiler plate; little-no understanding
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(0, TimeUnit.MICROSECONDS)
            .writeTimeout(2,TimeUnit.MINUTES)
            .writeTimeout(1,TimeUnit.MINUTES).build()

        retrofit = builder.client(okHttpClient).build()

    }

    fun getDonoList():DonoListService
    {

        return retrofit.create(DonoListService::class.java)
    }

    //TODO continue to study your HTTP methods and requests and build an interface to get the donations list
//    fun getAuthService():AuthAPIService{
//
//    }
    //fun getDonationsList():DonationAPIService{}
}