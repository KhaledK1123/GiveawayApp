package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.viewmodel.CreateAccountViewModel

class DonationCreate : ComponentActivity() {

    //private val viewModel1: CreateAccountViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {

                    TopAppBar(
                        backgroundColor = MaterialTheme.colors.primary,
                        title = {Text("Create Donation")})
                }
            )
            {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CreateDonationButton()
                }
            }
        }
    }
}


@Composable
fun CreateDonationButton(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {

        var itemName by rememberSaveable { mutableStateOf(value = "") }
        var description by rememberSaveable { mutableStateOf(value = "") }
        var location by rememberSaveable { mutableStateOf(value = "") }
        var tags by rememberSaveable { mutableStateOf(value = "") }


        TextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = {
                Text(
                    text = "Item Name",
                    style = MaterialTheme.typography.subtitle1
            ) },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium),

        )

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(
                text= "Description",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = location,
            onValueChange = { location = it },
            label = { Text(
                text = "Location",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = tags,
            onValueChange = { tags = it },
            label = { Text(
                text = "Tags",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        val backgroundColor = Color(0xFF673AB7)
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),
            onClick = {
                    context.startActivity(Intent(context, Home::class.java))
                    Toast.makeText(context,"Creating Donation!",Toast.LENGTH_LONG).show()
                }
            )
        {
            Text(
                text = "Create Donation!",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .padding(1.dp)
            )


        }
        CancelButton1()

    }
}
