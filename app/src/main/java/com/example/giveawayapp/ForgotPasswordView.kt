package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.giveawayapp.ui.theme.Shapes
import com.example.giveawayapp.viewmodel.ForgotPasswordViewModel
import com.example.giveawayapp.viewmodel.LoginViewModel

class ForgotPasswordView : ComponentActivity() {

    private val viewModel2: ForgotPasswordViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                SimpleText2("Create New Password")

                SubmitButton(viewModel2 = viewModel2)
            }
        }
    }
}

@Composable
fun SimpleText2(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        style =MaterialTheme.typography.h1,
        fontSize = 35.sp,
        modifier = Modifier.padding(top = 175.dp)
    )
}

@Composable
fun SubmitButton(modifier: Modifier = Modifier, viewModel2: ForgotPasswordViewModel) {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {


        var newPasswordInput by rememberSaveable { mutableStateOf("") }
        var confirmPasswordInput by rememberSaveable { mutableStateOf("") }

        TextField(
            value = newPasswordInput,
            onValueChange = { newPasswordInput = it },
            label = { Text("New Password") },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )
        TextField(
            value = confirmPasswordInput,
            onValueChange = { confirmPasswordInput = it },
            label = { Text("Confirm Password") },
            modifier = Modifier
                .padding(bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
                .border(.5.dp, MaterialTheme.colors.primaryVariant, Shapes.medium)
        )

        var status by rememberSaveable {
            mutableStateOf("")

        }

        val backgroundColor = Color(0xFF673AB7)
        Button(shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),

            onClick = { viewModel2.forgotPassword(newPasswordInput, confirmPasswordInput)
                if(viewModel2.successful() == true) {
                context.startActivity(Intent(context, MainActivity::class.java))
                }

            }) {

            Text(
                text = "Reset",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(1.dp)
            )
        }

        //Calling CancelButton function
        CancelButton()

    }
}