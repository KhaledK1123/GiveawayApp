package com.example.giveawayapp.itemOperations.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.network.ApiInterface
import com.example.giveawayapp.ui.theme.GiveawayAppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiveawayAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    printDonations()
                }
            }
        }
    }
}

fun printDonations () {

    //proper adherance to architecture will render this call properly; to be deleted
    //val call = retrofit.getDonations()

    var pojoDonationList = mutableListOf<Donation>()

//    call.enqueue(object: Callback<List<Donation>?> {
//
//
//            override fun onResponse(call: Call<List<Donation>?>, response: Response<List<Donation>?>) {
//                val responseBody = response.body()!!
//
//                for (Donation in responseBody) {
//                    pojoDonationList.add(Donation)
//                }
//            }
//
//            override fun onFailure(call: Call<List<Donation>?>, t: Throwable) {
//                Log.d("Main","onFailure: "+t.message)
//            }
//        }
//    )
}



