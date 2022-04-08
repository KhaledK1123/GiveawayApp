package com.example.giveawayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.model.DummyDonation.dummy
import com.example.giveawayapp.itemOperations.data.model.DummyDonation.dummyList
import com.example.giveawayapp.itemOperations.ui.ItemCard


class Social : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Composable
fun SocialScreen() {

Text(text = "Social View",
style = MaterialTheme.typography.h1)



}
@Preview(showBackground = true)
@Composable
fun SocialScreenPreview() {
    SocialScreen()
}

@Composable
fun Donations(donations: List<Donation>) {
    LazyColumn(Modifier.padding(40.dp)) {
        items(donations) { donation ->
            ItemCard(donation)
        }
    }
}

@Composable
fun SimpleText5(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        style = MaterialTheme.typography.h1,
        fontSize = 35.sp
    )
}

@Composable
fun RequestItem(choice: Donation) {


}