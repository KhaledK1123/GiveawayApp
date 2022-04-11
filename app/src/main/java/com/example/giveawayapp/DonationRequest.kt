package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.ui.theme.header


class DonationRequest : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DonationRequestButton()
        }
    }
}

@Composable
fun DonationRequestButton() {

    var request_box by rememberSaveable { mutableStateOf("") }
    var item_description by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val backgroundColor = Color(0xFF673AB7)

    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = header,
                title = { Text("Request Item") })
        }
    )
    {
        Spacer(modifier = Modifier.height(18.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Would you like this item? Let the Owner know why you need it!",
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                value = item_description,
                onValueChange = { item_description = it },
                label = { Text(text = "Why do you need this item?") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(0xFF673AB7),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),

                )

            Spacer(modifier = Modifier.height(50.dp))

            Button(shape = Shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
                modifier = Modifier
                    .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),

                onClick = {

                    //Traverses to the Home page
                    Toast.makeText(context, "Item Request Has Been Sent!", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context, Home::class.java))

                }) {
                Text(
                    text = "Submit",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(1.dp)
                )
            }
        }
    }
}