package com.example.giveawayapp.itemOperations

import android.util.Log
import com.example.giveawayapp.itemOperations.data.model.Donation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object myCallback: Callback<List<Donation>?> {
    var pojoDonationList = mutableListOf<Donation>()

    override fun onResponse(call: Call<List<Donation>?>, response: Response<List<Donation>?>) {
        val responseBody = response.body()!!

        for (Donation in responseBody) {
            pojoDonationList.add(Donation)
        }
    }

    override fun onFailure(call: Call<List<Donation>?>, t: Throwable) {
        Log.d("Main","onFailure: "+t.message)
    }
}