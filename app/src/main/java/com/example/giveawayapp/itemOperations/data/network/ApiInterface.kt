package com.example.giveawayapp.itemOperations.data.network

import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.model.DonationResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("donations/")
    suspend fun getDonations(): DonationResponse

}