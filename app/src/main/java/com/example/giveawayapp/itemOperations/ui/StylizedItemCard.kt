package com.example.giveawayapp.itemOperations.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.ProfileThumbnail
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.model.DummyDonation
import com.example.giveawayapp.ui.theme.background
import com.example.giveawayapp.ui.theme.header

@Composable

fun StylizedItemCard(donation: Donation = DummyDonation.dummy) {


    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = background
    ) {
        Column {
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
                text = donation.description,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                fontSize = 16.sp
            )
            LazyRow() {
                items (donation.tags.size) { i ->

                    TagCard(donation.tags[i])

                }
            }
        }
    }
}

@Composable
fun TagCard(tag: String) {
    Card(modifier = Modifier
        .padding(8.dp),
        backgroundColor = header) {

        Text(text = "#$tag",
            fontStyle = FontStyle.Italic,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.padding(2.dp))

    }
}

@Preview
@Composable
fun PreviewBIC() {
    StylizedItemCard()
}

@Preview
@Composable
fun PreviewTagCard () {
    TagCard("swag")
}
