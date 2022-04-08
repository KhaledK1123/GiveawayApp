package com.example.giveawayapp.itemOperations.ui

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giveawayapp.R
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.model.DummyDonation



@Composable
fun ItemClickable(navController: NavController,
                  donation: Donation,
                  onItemClicked: (item: Donation) -> Unit
) {

    ItemCard(donation = donation,
        modifier = Modifier
            .padding(8.dp)
            .clickable { //TODO connect to navController
//            onItemClicked(donation)
//            navController.navigate("")
            })

}

//@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(donation: Donation, modifier:Modifier = Modifier
    .padding(8.dp)
    .clickable { //TODO connect to navController
    }
)
{
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.img2),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

    Card(elevation = 10.dp, modifier = Modifier.padding(10.dp), border = BorderStroke(1.dp, Color.Black)) {//.fillMaxWidth()
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            LazyRow {
                items(donation.images.size){ index ->
                    Text(text = donation.images[index])
                }
            }
            Divider()
            Text(text = " Item Name: ")
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                        Text(
                            text = donation.donationName,
                            modifier = Modifier.padding(all = 4.dp),
                            // If the message is expanded, we display all its content
                            // otherwise we only display the first line
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                            style = MaterialTheme.typography.body1
                        )
                    }
            Divider()
            Text(text = " Description: ")
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = donation.description,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
            Divider()
            Text(text = " Location: ")
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = donation.location,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
            Divider()
            Text(text = " Time posted: ")
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {

                Text(
                    text = donation.time,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
            Divider()
            Text(text = " Published by: ")
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = donation.publisher,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
            Divider()
            Text(text = " Tags: ")
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                LazyRow {
                    items(donation.tags.size) { index ->
                        Text(text = donation.tags[index])
                    }
            }


            }
            Divider()
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                val context = LocalContext.current
                TextButton(onClick = {
                    Toast.makeText(context,"Requested Item....", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "Request Item")
                }
                }
                //and these subtitle formats:

//                Text(text = donation.time)
//                Divider()
//                LazyRow {
//                    items(donation.tags.size) { index ->
//                        Text(text = donation.tags[index])
//                    }
                }
                }
        }
//
    }

@Composable
@Preview
fun ItemListPreview() {
    ItemCard(donation = DummyDonation.dummy)
}