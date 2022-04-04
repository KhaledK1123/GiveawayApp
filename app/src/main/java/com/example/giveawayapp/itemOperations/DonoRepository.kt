package com.example.giveawayapp.itemOperations

class DonoRepository(val donationService: DonationService) {

    suspend fun fetchDonationList(): List<Donation> {

        return donationService.getDonations()
    }
}