package com.example.giveawayapp.itemOperations.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.giveawayapp.itemOperations.data.model.DonationResponse
import com.example.giveawayapp.itemOperations.data.model.DummyDonation
import com.example.giveawayapp.itemOperations.data.network.DonationsApiClient
import com.example.giveawayapp.itemOperations.data.repository.DonationRepository
import com.example.giveawayapp.itemOperations.viewmodel.DonationViewModel
import kotlinx.coroutines.launch

@Composable
fun ListReusable (navController: NavController,
    /*This could be abstracted:*/
    viewModel: DonationViewModel) {

    DonationList()

}

@Composable
fun DonationList() {
    val donationList = DonationViewModel().donationList
    var listState = rememberLazyListState()
    LazyColumn(state = listState) {

        items(donationList.size) {index ->
            ItemCard(
                donation = donationList[index]
            )
        }
    }
}

//@Preview
//@Composable
//fun DonationCardPreview() {
//
//    val coroutineScope = rememberCoroutineScope()
//    val client = DonationsApiClient.service
//    val repository = DonationRepository(client)
//    coroutineScope { val response = repository.fetchDonationList() }
//    ItemCard()
////ItemCard(DummyDonation.dummy)
//}
//

