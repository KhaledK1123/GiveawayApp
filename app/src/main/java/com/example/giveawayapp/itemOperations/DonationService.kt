package com.example.giveawayapp.itemOperations

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DonationService {

    @GET("/donations")
    suspend fun getDonations(): List<Donation>

//    @POST("/donations")
//    suspend fun postDonations(@Body newDono: NewDono): Response<SuccessMessage>

    //@GET("donations/{}")


    //what about this block? what does it mean?
//    suspend fun getLogin(@Body login: Login): Response<Donation>
}