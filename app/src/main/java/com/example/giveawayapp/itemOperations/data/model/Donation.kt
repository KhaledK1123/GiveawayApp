package com.example.giveawayapp.itemOperations.data.model

import com.google.gson.annotations.SerializedName

data class Donation (

    @SerializedName("id")
    val id: Int,

    @SerializedName("donation")
    val donationName: String,

    @SerializedName("donor_username")
    val donor_username: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("time")
    val time: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("tags")
    val tags: Array<String>,

    @SerializedName("images")
    val images: Array<String>
        )  {



}
