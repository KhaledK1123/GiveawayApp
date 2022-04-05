package com.example.giveawayapp.network.repository

import com.example.giveawayapp.network.Login
import com.example.giveawayapp.network.token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {

    @POST("authentication")
    suspend fun getLogin(@Body login: Login): Response<token>

//    @POST("createAccount")
//    suspend fun getCreateAccount(@Body createAccount: CreateAccount): Response<getResponse>
}