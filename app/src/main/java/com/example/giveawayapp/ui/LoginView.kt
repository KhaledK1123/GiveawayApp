package com.example.giveawayapp.ui

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.CreateAccountView
import com.example.giveawayapp.ForgotPasswordView
import com.example.giveawayapp.Home
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.viewmodel.LoginViewModel

@Composable
fun LoginText(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        style= MaterialTheme.typography.h2,
        modifier = Modifier.padding(top = 175.dp),
        fontSize = 40.sp,
    )
}

@Composable
fun ForgotPasswordButton() {

    val context = LocalContext.current
    TextButton(
        onClick = {
            context.startActivity(Intent(context, ForgotPasswordView::class.java))
        },
        modifier = Modifier.absolutePadding(left = 235.dp)
    ) {
        Text("Forgot Password", style = MaterialTheme.typography.subtitle1, color = Color(0xFF673AB7))
    }
}

@Composable
fun CreateAccountButton() {

    Divider(modifier = Modifier.padding(top = 100.dp), color = Color.LightGray)
    Row() {
        Column(

            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 15.dp),
            Arrangement.Bottom
        ) {

            Text(text = "Don't have an account?", style = MaterialTheme.typography.h6)
        }

        Row() {

            Column(

                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 6.dp),
                Arrangement.Bottom
            ) {

                val context = LocalContext.current
                TextButton(
                    onClick = {
                        context.startActivity(Intent(context, CreateAccountView::class.java))
                    },

                    ) {
                    Text("Sign Up", style = MaterialTheme.typography.h6, color = Color(0xFF673AB7))
                }
            }
        }
    }
}

@Composable
fun LoginView(modifier: Modifier = Modifier, viewModel: LoginViewModel) {
    LocalContext.current

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {
        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }


        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("User Name", style = MaterialTheme.typography.subtitle1) },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", style = MaterialTheme.typography.subtitle1) },
            modifier = Modifier
                .padding(bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

    }

    //Calling ForgotPasswordButton function that displays 'Forgot Password'
    ForgotPasswordButton()

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val backgroundColor = Color(0xFF673AB7)

    Button(shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),

        onClick = { viewModel.login(username, password)

            //This allows the login button to traverse to Home page
            if(viewModel.successful() == true) {

                context.startActivity(Intent(context, Home::class.java))
                Toast.makeText(context,"Login Successful!", Toast.LENGTH_LONG).show()
            }

        }) {

        Text(
            text = "Login",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(1.dp)
        )
    }


    //Calling CreateAccountButton function that displays 'Sign Up' at the bottom
    CreateAccountButton()
}