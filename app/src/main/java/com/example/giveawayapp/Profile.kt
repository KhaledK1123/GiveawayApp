package com.example.giveawayapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
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

            //ProfileScreen()
            MainScreen()
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

        status = "Please indicate the next donation you'd like to make, " +
                "or return to the Home screen"
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

// Instantiate, for line 121 call
fun Button(shape: RoundedCornerShape, colors: ButtonColors, modifier: Modifier,
           onClick: () -> Unit) {

}

@Composable
fun ProfileScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.TopCenter)
    ) {
        //SimpleText2("Donate Item")

        //SubmitButton2()

        ProfileSection()
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

@Composable
fun ProfileSection(){
    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Profile")})
        }
    )
    {
    Column(Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.img2),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(10.dp))
        ProfileDescription(
            displayName = "John Adams",
            username = "AdamsApple74",
            email = "JohnnyBoy74@gmail.com",
            address = "47129 Cabron Ave, Winchester, CA, 92596",
            donationCount = 18
        )
        Column(

            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 75.dp),
            Arrangement.Top,
            Alignment.CenterHorizontally
        ) {
            belowProfile()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
                Arrangement.Bottom,
                Alignment.Start

        ) {
            val context = LocalContext.current
            TextButton(
                onClick = {
                    context.startActivity(Intent(context, EditProfileView::class.java))
                },
            ) {
                Text(
                    "Edit Profile",
                    style = MaterialTheme.typography.button,
                    color = Color(0xFF673AB7)
                )
            }
        }
    }
    }
}
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}
@Composable
fun StatSection(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "18", text = "Donations")
        ProfileStat(numberText = "16", text = "Items Received")
        ProfileStat(numberText = "523", text = "Flair")
    }
}
@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    username: String,
    email: String,
    address: String,
    donationCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Name: $displayName",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Username: $username",
            style = MaterialTheme.typography.body1,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Email: $email",
            style = MaterialTheme.typography.body1,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Address: $address",
            style = MaterialTheme.typography.body1,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = buildAnnotatedString {
                    append("Donated $donationCount times!")
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun belowProfile()
{
    var selectedTabIntex by remember {
        mutableStateOf(0)
    }
    PostTabView(
        imageWithText = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.ic_grid),
                text = "Posts"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_reels),
                text = "Reels"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_igtv),
                text = "IGTV"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.ic_profile),
                text = "Profile"
            ),
        )
    ){
        selectedTabIntex = it
    }
    when(selectedTabIntex){
        0 -> PostSection(
            posts = listOf(
                painterResource(id = R.drawable.iphone),
                painterResource(id = R.drawable.mercedes)

            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}
@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}



/* Lines 448-570: For reference only, now)

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

/* Fixing earlier lines' errors (1-2, depending): function needed, to balance
- @ end of last composable */
'fun Button(shape: RoundedCornerShape, colors: ButtonColors, modifier: Modifier,
           onClick: () -> Unit) {
 */


