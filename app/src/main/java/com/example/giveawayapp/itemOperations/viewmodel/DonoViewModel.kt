package com.example.giveawayapp.itemOperations.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.network.RichardsRetrofitHelper
import com.example.giveawayapp.itemOperations.data.repository.DonationRepository

class DonoViewModel:ViewModel() {

    private val apiService = RichardsRetrofitHelper.getDonationService()
    private lateinit var repository: DonationRepository

    var donationList: List<Donation> by mutableStateOf(listOf())

    lateinit var clickedItem: Donation

    //it is possible I may need to use a clicked item
    //Why does Mayur use it?

    init {
        fetchDonationViewModel()
    }

    private fun fetchDonationViewModel() {

        repository = DonationRepository(apiService)
        viewModelScope.launch {
            var response = repository.fetchDonationList()
            when(response)
            {
                is DonationRepository.Result.Success ->
                {
                    Log.d("MainViewModel","Success")
                    donationList = response.donationList
                }
                is DonationRepository.Result.Failure ->
                {
                    Log.d("MainViewModel","Failure")
                }
            }
        }
    }

    fun itemClicked(item:Donation)
    {
        clickedItem=item
    }
}