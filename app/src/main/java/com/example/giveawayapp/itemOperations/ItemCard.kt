package com.example.giveawayapp.itemOperations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun itemCard(donation: Donation)
{
    Card(onClick = { /*Send intent with donation object to Item Page*/ }) {
        Column(Modifier.fillMaxWidth()) {
            Text(text = "${donation.images}")//simply needs to convert array to text items
            Divider()
            Text(text = "${donation.donationName}")//give this a header format
            //and these sub formats:
            Text(text = "${donation.donor_username}")
            Text(text = "${donation.time}")
            Divider()
            Text(text = "${donation.tags}")//same as donation.images
        }

    }
}

@Composable
@Preview
fun itemListPreview() {
    itemCard(donation = dummyDonation.dummy)
}