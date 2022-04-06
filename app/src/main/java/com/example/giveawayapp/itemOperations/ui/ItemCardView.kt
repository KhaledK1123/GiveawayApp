package com.example.giveawayapp.itemOperations.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.model.DummyDonation

@Composable
fun ItemClickable(navController: NavController,
                  donation: Donation,
                  onItemClicked: (item: Donation) -> Unit
) {

    ItemCard(donation = donation,
        modifier = Modifier.padding(8.dp)
        .clickable { //TODO connect to navController
//            onItemClicked(donation)
//            navController.navigate("")
        })

}

//@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(donation: Donation, modifier:Modifier = Modifier.padding(8.dp)
                                                    .clickable { //TODO connect to navController
                                                //            onItemClicked(donation)
                                                //            navController.navigate("")
                                                    }
)
{
    Card(modifier = Modifier) {
        Column(Modifier.fillMaxWidth()) {
            LazyRow {
                items(donation.images.size){ index ->
                    Text(text = donation.images[index])
                }
            }
            Divider()
            Text(text = donation.donationName)//give this a header format
            //and these subtitle formats:
            Text(text = donation.publisher)
            Text(text = donation.time)
            Divider()
            LazyRow {
                items(donation.tags.size){ index ->
                    Text(text = donation.tags[index])
                }
            }

        }

    }
}

@Composable
@Preview
fun ItemListPreview() {
    ItemCard(donation = DummyDonation.dummy)
}