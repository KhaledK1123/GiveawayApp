package com.example.giveawayapp.itemOperations.data.repository

import android.util.Log
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.network.ApiInterface

class DonationRepository(val donationService: ApiInterface) {

    sealed class Result /*Creates data classes which returns either a movieList
                            or a throwable failure
                        */
    {
        data class Success(val donationList: List<Donation>): Result()
        data class Failure(val throwable: Throwable): Result()
    }

    suspend fun fetchDonationList():Result {

        return try {

            /*initializing a donation list, gained through our API interface
                using the GET method (which returns a response and contains
                a field with the name donationList)*/
            val donationList = donationService.getDonations().donationList

            //Helpful logcat entry
            Log.d("DonationList","Success"+donationList.size)

            //Finally, the Result object to return, which is of type success
            Result.Success(donationList = donationList)

        } catch (exception: Exception) {

            Log.d("DonationList","Failure")
            Result.Failure(exception)

        }
    }
}