package com.example.giveawayapp.itemOperations

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface DonoListService {

    @GET("donations/")
    suspend fun getDonoList(@Body donation: Donation): Response<Donation>


    //what about this block? what does it mean?
//    suspend fun getLogin(@Body login: Login): Response<Donation>
}