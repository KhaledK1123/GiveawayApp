package com.example.giveawayapp.itemOperations

object dummyDonation {
    val dummy = Donation(
        id = 0,
        donationName = "Dummy",
        donor_username = "rescueAnne",
        location = "Paris, France",
        time = "03/27/2022, 12:34",
        description = "A dummy donation",
        tags = arrayOf("L'Inconnue de la Seine", "La Belle Italienne"),//needs conversion
        images = arrayOf("mask", "dummy")//Kotlin will print the name of the data and not the data
    )
}