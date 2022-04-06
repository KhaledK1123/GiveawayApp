package com.example.giveawayapp.itemOperations.data.model

import com.example.giveawayapp.itemOperations.data.model.Donation

object DummyDonation {
    val dummy = Donation(
        id = 0,
        donationName = "Dummy",
        publisher = "rescueAnne",
        location = "Paris, France",
        time = "03/27/2022, 12:34",
        description = "A dummy donation",
        tags = listOf<String>("L'Inconnue de la Seine", "La Belle Italienne"),//needs conversion
        images = listOf<String>("mask", "dummy")//Kotlin will print the name of the data and not the data
    )
}