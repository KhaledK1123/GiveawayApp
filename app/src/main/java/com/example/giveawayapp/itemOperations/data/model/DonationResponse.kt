package com.example.giveawayapp.itemOperations.data.model

import com.google.gson.annotations.SerializedName

data class DonationResponse (

    @SerializedName("Donation List")
    var donationList: List<Donation>

    )