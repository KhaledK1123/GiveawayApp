package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Composable
fun LoginText(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 45.sp,
        modifier = Modifier.padding(top = 175.dp)
    )
}

fun LoginInput(user_name: String, password: String): String {

    val status: String

    if (user_name.equals("John") && password.equals("password")) {

        status = "Login Successful"

    } else {

        status = "Login Unsuccessful"
    }

    return status
}

@Composable
fun ForgotPasswordButton() {

    val context = LocalContext.current
    TextButton(
        onClick = {
            context.startActivity(Intent(context, ForgotPassword::class.java))
        },
        modifier = Modifier.absolutePadding(left = 235.dp)
    ) {
        Text("Forgot Password", fontSize = 15.sp, color = Color(0xFF673AB7))
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

            Text(text = "Don't have an account?", fontSize = 18.sp)
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
                        context.startActivity(Intent(context, CreateAccount::class.java))
                    },

                    ) {
                    Text("Sign Up", fontSize = 18.sp, color = Color(0xFF673AB7))
                }
            }
        }
    }
}

@Composable
fun Login() {
    LocalContext.current

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {

        var usernameInput by rememberSaveable { mutableStateOf("") }
        var passwordInput by rememberSaveable { mutableStateOf("") }

        TextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            label = { Text("User Name") },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )
        TextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text("Password") },
            modifier = Modifier
                .padding(bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        var status by rememberSaveable {
            mutableStateOf("")

        }

        //Calling ForgotPasswordButton function that displays 'Forgot Password'
        ForgotPasswordButton()

        val context = LocalContext.current
        val backgroundColor = Color(0xFF673AB7)
        if (usernameInput == ("John") && passwordInput == ("password")) {
            Button(shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),

                onClick = {
                    status = LoginInput(usernameInput, passwordInput); context.startActivity(
                    Intent(context, CreateAccount::class.java)
                )
                }) {

                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(1.dp)
                )
            }
        } else {
            Button(shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),

                onClick = {
                    status = LoginInput(usernameInput, passwordInput)
                }) {

                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(1.dp)
                )
            }
        }
        Text(text = status)
    }

    //Calling CreateAccountButton function that displays 'Sign Up' at the bottom
    CreateAccountButton()
}