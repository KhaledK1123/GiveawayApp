package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Profile : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Composable
fun SimpleText4(displayText:String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 35.sp,
        modifier = Modifier.padding(top = 175.dp)
    )
}

fun DonateItemInput(donate_item: String, confirm_donation_complete: String): String {

    var status: String = ""

    if (donate_item.equals("donation") && confirm_donation_complete.equals("complete")) {

        status = "Confirmed"

    } else {

        status = "Please indicate the next donation you'd like to make"
    }

    return status

}

@Composable
fun SubmitButton2() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {
        var donateItemInput by rememberSaveable { mutableStateOf("") }
        var confirmDonationCompleteInput by rememberSaveable { mutableStateOf("") }

        TextField(
            value = donateItemInput,
            onValueChange = { donateItemInput = it },
            label = { Text("Donating an Item") },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )
        TextField(
            value = confirmDonationCompleteInput,
            onValueChange = { confirmDonationCompleteInput = it },
            label = { Text("Please Confirm That Your Donation is Complete") },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
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
            onClick = {
                status =
                    DonateItemInput(donateItemInput, confirmDonationCompleteInput);
                    context.startActivity(Intent(context, MainActivity::class.java)
                    )
            }
        )
    }
}

// Instantiate, for line 112 call
fun Button(shape: RoundedCornerShape, colors: ButtonColors, modifier: Modifier,
           onClick: () -> Unit) {

}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Profile View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        SimpleText4("Donate Item")

        SubmitButton2()
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}


/* Lines 133-256: IF PW change/update is NEEDED, to connect to an API
                SimpleText >4("Change Your Password")

                SubmitButton >2()
            }
        }
    }
}

@Composable
fun SimpleText >4(displayText: String) {

    Text(
        color = Color(0xFF673AB7),
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 35.sp,
        modifier = Modifier.padding(top = 175.dp)
    )
}

//Should donor want to update password
@Composable
fun ChangePassword(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 15.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 75.dp)
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ConfirmPasswordChange(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 15.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 50.dp)
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
    )
}

// Other statements ('if-else', or similar?) needed, after line 98 ??
fun ChangePasswordInput(change_password: String, confirm_password_change: String): String
{
   var status: String = ""

    if (change_password.equals("password2") && confirm_password_change.equals("password2")) {

        status = "Change Confirmed"

    } else {

        status = "You have already used this password. Please create another one."
    }

    return status
}

@Composable
fun SubmitButton >2() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    )
    {

        var it: String = ""
        var changePasswordInput by rememberSaveable { mutableStateOf("") }
        var confirmPasswordChange by rememberSaveable { mutableStateOf("") }

        TextField(
            value = changePasswordInput,
            onValueChange = { changePasswordInput = it },
            label = { Text("Changing Password to") },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )
        TextField(
            value = confirmPasswordChange,
            onValueChange = { confirmPasswordChange = it },
            label = { Text("Confirm Password Change") },
            modifier = Modifier
                .padding(bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        var status by rememberSaveable { mutableStateOf("") }

        val backgroundColor = Color(0xFF673AB7)
        Button(shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            onClick = {
                status =
                    ChangePasswordInput(changePasswordInput, confirmPasswordChange);
                context.startActivity(Intent(context, MainActivity::class.java))

            })
    }
}

/* Fixing Line 150 errors (1-2, depending): function needed, to balance
- @ end of last composable */
fun Button(shape: RoundedCornerShape, colors: ButtonColors, modifier: Modifier,
           onClick: () -> Unit) {
 */


