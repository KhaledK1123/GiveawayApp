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

class EditProfileView : ComponentActivity() {
//DOESNT WORK CURRENTLY
    //private val viewModel1: CreateAccountViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SimpleText3("Edit Profile")

                //CreateAccountButton1()
            }
        }
    }
}


@Composable
fun CreateAccountButton1(modifier: Modifier = Modifier) {

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
            label = {
                Text(
                    text = "Full Name",
                    style = MaterialTheme.typography.subtitle1
            ) },

            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium),

        )

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(
                text= "Username",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(
                text = "Email",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text(
                text = "Address",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text(
                text = "City",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = state,
            onValueChange = { state = it },
            label = { Text(
                text = "State",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = zipCode,
            onValueChange = { zipCode = it },
            label = { Text(
                text = "Zip Code",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(
                text = "Password",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(
                text = "Confirm Password",
                style = MaterialTheme.typography.subtitle1
            ) },
            modifier = Modifier
                .padding(top = 5.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
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
                .fillMaxWidth()
                .clip(Shapes.medium),

            onClick = {
                    context.startActivity(Intent(context, Home::class.java))
                    Toast.makeText(context,"Profile Updated!",Toast.LENGTH_LONG).show()
                }
            )
        {
            Text(
                text = "Update",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .padding(1.dp)
            )

        }


    }
}
