package com.example.giveawayapp.itemOperations.data.model

import com.google.gson.annotations.SerializedName

data class Donation(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("publisher")
    override val publisher: String,

    @SerializedName("donation")
    val donationName: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("time")
    val time: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("tags")
    val tags: List<String>,

    @SerializedName("images")
    val images: List<String>
    ) : Listable()