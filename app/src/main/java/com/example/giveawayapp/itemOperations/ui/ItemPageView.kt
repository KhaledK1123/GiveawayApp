package com.example.giveawayapp.itemOperations.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.network.ApiInterface
import com.example.giveawayapp.itemOperations.viewmodel.DonationViewModel
import com.example.giveawayapp.ui.theme.GiveawayAppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun ListReusable (navController: NavController,
    /*This could be abstracted:*/
    viewModel: DonationViewModel) {

    DonationList(navController = navController,
        donationList = viewModel.donationList,
        onItemClicked = viewModel::itemClicked
        )

}

@Composable
fun DonationList (
    navController: NavController,
    donationList: List<Donation>,
    onItemClicked: (item:Donation) -> Unit
) {
    var listState = rememberLazyListState()
    var donationList =
    LazyColumn(state = listState) {

        itemsIndexed(donationList) {index, item ->
            ItemClickable(
                navController = navController,
                donation = donationList[index],
                onItemClicked
            )
        }
    }
}



