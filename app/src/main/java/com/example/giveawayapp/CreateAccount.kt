package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class CreateAccount : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SimpleText3("Create Account")

                CreateAccountButton1()
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
fun CreateAccountButton1() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {

        var fullNameFieldText by rememberSaveable { mutableStateOf("") }
        var usernameFieldText by rememberSaveable { mutableStateOf("") }
        var emailFieldText by rememberSaveable { mutableStateOf("") }
        var addressFieldText by rememberSaveable { mutableStateOf("") }
        var cityFieldText by rememberSaveable { mutableStateOf("") }
        var stateFieldText by rememberSaveable { mutableStateOf("") }
        var zipCodeFieldText by rememberSaveable { mutableStateOf("") }
        var passwordFieldText by rememberSaveable { mutableStateOf("") }
        var confirmPasswordFieldText by rememberSaveable { mutableStateOf("") }

        TextField(
            value = fullNameFieldText,
            onValueChange = { fullNameFieldText = it },
            label = { Text("Full Name") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = usernameFieldText,
            onValueChange = { usernameFieldText = it },
            label = { Text("Username") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = emailFieldText,
            onValueChange = { emailFieldText = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = addressFieldText,
            onValueChange = { addressFieldText = it },
            label = { Text("Address") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = cityFieldText,
            onValueChange = { cityFieldText = it },
            label = { Text("City") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = stateFieldText,
            onValueChange = { stateFieldText = it },
            label = { Text("State") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = zipCodeFieldText,
            onValueChange = { zipCodeFieldText = it },
            label = { Text("Zip Code") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = passwordFieldText,
            onValueChange = { passwordFieldText = it },
            label = { Text("Password") },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        TextField(
            value = confirmPasswordFieldText,
            onValueChange = { confirmPasswordFieldText = it },
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
            onClick = {

                context.startActivity(Intent(context, MainActivity::class.java))
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