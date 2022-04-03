package com.example.giveawayapp.itemOperations

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface New4UApi {

    @GET("/donations")
    fun getDonations(): Response<Donation>

    //@GET("donations/{}")


    //what about this block? what does it mean?
//    suspend fun getLogin(@Body login: Login): Response<Donation>
}