package com.example.giveawayapp.itemOperations.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.giveawayapp.itemOperations.data.network.RichardsRetrofitHelper

class DonoViewModel:ViewModel() {

private val apiService = RichardsRetrofitHelper
//    private val donationService = RichardsRetrofitHelper.donationService
//    private lateinit var repository: DonoRepository
//
//    var donations: List<Donation> by mutableStateOf(listOf())
//
//        lateinit var clickedItem: Donation
//
//        init {
//            fetchDonationList()
//        }
//
//    fun fetchDonationList() {
//        var response = DonoRepository(donationService)
//        viewModelScope.launch {
//            //var donations = repository.fetchDonationList()
//
//        }
//    }
}