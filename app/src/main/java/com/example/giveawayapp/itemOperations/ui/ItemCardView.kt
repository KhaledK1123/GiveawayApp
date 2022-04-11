package com.example.giveawayapp.itemOperations.ui

import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.giveawayapp.DonationRequest
import com.example.giveawayapp.MainActivity
import com.example.giveawayapp.ProfileThumbnail
import com.example.giveawayapp.R
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.model.DummyDonation
import com.example.giveawayapp.ui.theme.background
import com.example.giveawayapp.ui.theme.header


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


        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.surface else MaterialTheme.colors.primaryVariant,
        )

    Card(elevation = 10.dp,
        modifier = Modifier.padding(10.dp),
        backgroundColor = background,
        border = BorderStroke(1.dp,
            MaterialTheme.colors.primaryVariant)) {

        //.fillMaxWidth()
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(header)
            ) {
                Text(
                    text = donation.donationName,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Divider()

            LazyRow {
                items(donation.images.size) { index ->
                    //Text(text = donation.images[index])
                    Image(painter = painterResource(id = donation.images[index]),
                        contentDescription =null,
                        modifier= Modifier
                            .size(250.dp)
                            .padding(8.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
//            Surface(
//                shape = MaterialTheme.shapes.medium,
//                elevation = 1.dp,
//                // animateContentSize will change the Surface size gradually
//                modifier = Modifier
//                    .animateContentSize()
//                    .padding(1.dp)
//            ) {

//            Text(
//                text = "Item Name: " + donation.donationName,
//                modifier = Modifier.padding(all = 4.dp),
//                // If the message is expanded, we display all its content
//                // otherwise we only display the first line
//                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//                style = MaterialTheme.typography.body1
//            )

            Row(modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                ProfileThumbnail()
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = donation.publisher,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Published at "+ donation.time+", in " +donation.location,
                        color = Color.DarkGray,
                        fontSize = 10.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
            }

            Text(
                text = "Description: " + donation.description,
                modifier = Modifier.padding(all = 8.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2
            )
//            Text(
//                text = "Location: " + donation.location,
//                modifier = Modifier.padding(all = 4.dp),
//                // If the message is expanded, we display all its content
//                // otherwise we only display the first line
//                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//                style = MaterialTheme.typography.body2
//            )
//            Text(
//                text = "Time Posted: " + donation.time,
//                modifier = Modifier.padding(all = 4.dp),
//                // If the message is expanded, we display all its content
//                // otherwise we only display the first line
//                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//                style = MaterialTheme.typography.body2
//            )
            Text(text = " Tags: ",
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp))
            LazyRow() {
                items (donation.tags.size) { i ->

                    TagCard(donation.tags[i])

                }
            }
//            Text(
//                text = "Published By: " + donation.publisher,
//                modifier = Modifier.padding(all = 4.dp),
//                // If the message is expanded, we display all its content
//                // otherwise we only display the first line
//                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//                style = MaterialTheme.typography.body2
//            )
//            Row(modifier = Modifier.padding(all = 8.dp)) {
//                Image(
//                    painter = painterResource(R.drawable.img2),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clip(CircleShape)
//                        .border(1.5.dp, MaterialTheme.colors.primaryVariant, CircleShape)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//            }



            Divider()

            Row(modifier = Modifier.padding(8.dp)) {

                val context = LocalContext.current

                TextButton(onClick = {
                    context.startActivity(Intent(context, DonationRequest::class.java))
                    Toast.makeText(context,"Requested Item....", Toast.LENGTH_LONG).show()

                }) {
                    Text(text = "Request Item")
                }}


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

@Composable
@Preview
fun ItemListPreview() {
    ItemCard(donation = DummyDonation.dummy)
}