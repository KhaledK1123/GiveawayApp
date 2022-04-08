package com.example.giveawayapp.itemOperations.data.model

import com.example.giveawayapp.DonationList
import com.example.giveawayapp.itemOperations.data.model.Donation

object DummyDonation {
    val dummy = Donation(
        id = 0,
        donationName = "2003 Mercedes Benz",
        publisher = "Patrick Reeves",
        location = "Paris, France",
        time = "03/27/2022, 12:34",
        description = "Black 2003 Mercedes Benz in good condition. Needs gas, and a new steering wheel",
        tags = listOf<String>(" Vehicle", " Driving", " Travel"),//needs conversion
        images = listOf<String>(" Img 1", " Img 2")//Kotlin will print the name of the data and not the data
    )
    val dummy1 = Donation(
        id = 1,
        donationName = "Xbox 360",
        publisher = "Abraham Lincoln",
        location = "Winchester, CA",
        time = "07/02/2021, 11:24",
        description = "Xbox 360 in average condition. Needs controller, and a hard drive.",
        tags = listOf<String>(" Gaming", " Xbox", " Console"),//needs conversion
        images = listOf<String>(" Img 1", " Img 2")//Kotlin will print the name of the data and not the data
    )
    val dummyList:List<Donation> = listOf(dummy, dummy1)
}