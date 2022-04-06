package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.viewmodel.CreateAccountViewModel

class CreateAccountView : ComponentActivity() {

    private val viewModel1: CreateAccountViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SimpleText3("Create Account")

                CreateAccountButton1(viewModel1 = viewModel1)
            }
        }
    }
}

@Composable
fun SimpleText3(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 35.sp,
    )
}

@Composable
fun CreateAccountButton1(modifier: Modifier = Modifier, viewModel1: CreateAccountViewModel) {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {

        var fullName by rememberSaveable { mutableStateOf(value = "") }
        var username by rememberSaveable { mutableStateOf(value = "") }
        var email by rememberSaveable { mutableStateOf(value = "") }
        var address by rememberSaveable { mutableStateOf(value = "") }
        var city by rememberSaveable { mutableStateOf(value = "") }
        var state by rememberSaveable { mutableStateOf(value = "") }
        var zipCode by rememberSaveable { mutableStateOf(value = "") }
        var password by rememberSaveable { mutableStateOf(value = "") }
        var confirmPassword by rememberSaveable { mutableStateOf(value = "") }

        TextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("City") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = state,
            onValueChange = { state = it },
            label = { Text("State") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = zipCode,
            onValueChange = { zipCode = it },
            label = { Text("Zip Code") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier
                .padding(top = 5.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        val backgroundColor = Color(0xFF673AB7)
        Button(
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),

            onClick = {viewModel1.createAccount(fullName,username,email,address,city
                ,state,zipCode,password,confirmPassword)
                if(viewModel1.successful() == true) {
                    context.startActivity(Intent(context, MainActivity::class.java))
                }
            })
        {
            Text(
                text = "Create Account",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(1.dp)
            )

        }

        //Calling CancelButton function
        CancelButton()
    }
}

@Composable
fun CancelButton() {

    Column(
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom, Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        TextButton(
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            },

            ) {
            Text("Cancel", fontSize = 15.sp, color = Color(0xFF673AB7))
        }
    }
}