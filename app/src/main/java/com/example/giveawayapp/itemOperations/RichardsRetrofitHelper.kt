package com.example.giveawayapp.itemOperations

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KProperty

object RichardsRetrofitHelper {

    private const val BASE_URL = "https://private-15a842-new4u.apiary-mock.com"
    private val retrofit: Retrofit

    init{

            val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
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

    /* Capital 'L', for line 40, REMOVES constant, red underline, from 41-43, but 'Lazy', being
     there at all, remains a problem, w/intellisense */
//    val donationService: ApiInterface by Lazy{
//        retrofit.create(ApiInterface::class.java)
//    }
}

/* 'private operator fun <T> Lazy<T>.getValue(richardsRetrofitHelper: RichardsRetrofitHelper,
property: KProperty<T?>): T { }' > suggested, to get rid of lines 41-43 constant, red underline:
didn't work; tried other ideas */

/* 'Retrofit retrofit = new Retrofit.Builder()' > this one shows up, on square.github.io/retrofit/;
tried it here: no effect; may belong SOMEWHERE here, though */