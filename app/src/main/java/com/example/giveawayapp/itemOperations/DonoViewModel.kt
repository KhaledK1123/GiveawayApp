package com.example.giveawayapp.itemOperations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DonoViewModel:ViewModel() {

    fun displayDonos()
    {
        //try catch block to hold
        viewModelScope.launch(Dispatchers.IO){
            try
            {
                val listDonos = RichardsRetrofitHelper.getDonoList()
            }
            catch (e: Exception)
            {

            }
        }
    }
}