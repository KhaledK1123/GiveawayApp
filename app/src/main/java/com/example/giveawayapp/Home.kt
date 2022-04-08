package com.example.giveawayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.giveawayapp.itemOperations.data.model.Donation
import com.example.giveawayapp.itemOperations.data.model.DummyDonation
import com.example.giveawayapp.itemOperations.ui.ItemCard
import com.example.giveawayapp.itemOperations.ui.ItemClickable

class Home : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //column()
        setContent {
            MainScreen()
            }





//
//
////            var selectedItem by remember { mutableStateOf(0) }
////            val items = listOf("Songs", "Artists", "Playlists")
////            BottomNavigation (
////            ){
////                items.forEachIndexed { index, item ->
////                    BottomNavigationItem(
////
////                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
////                        label = { Text(item) },
////                        selected = selectedItem == index,
////                        onClick = { selectedItem = index }
////                    )
////                }
////            }
//
//        }
    }
}
//@Composable
//fun column()
//{
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        SimpleText3("Home")
//        val context = LocalContext.current
//        TextButton(
//            onClick = {
//                Toast.makeText(context,"Home", Toast.LENGTH_LONG).show()
//            })
//        {
//            Text("Home", color = Color(0xFF2196F3))
//        }
//
//
//    }
//}
@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleText5(displayText = "Donations")
        Column(
            horizontalAlignment = Alignment.End
        ) {
            androidx.compose.material.Button(onClick = { /*TODO*/ }) {
                Text(text = "Create Post")
            }
        }
        Donations(donations = DummyDonation.dummyList)
    }
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Social,
        NavigationItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.purple_500),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    //BottomNavigationBar()
}


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        //topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController = navController) },

    ) {
        Navigation(navController)
        //LazyDonationList(donations = DonoViewModel.donations)
    }
}

@Composable
fun TopBar() {

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Social.route) {
            SocialScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun DonationList (
    navController: NavController,
    donationList: List<Donation>,
    onItemClicked: (item:Donation) -> Unit
) {
    var listState = rememberLazyListState()

    LazyColumn(state = listState) {

        itemsIndexed(donationList) {index, item ->
            ItemClickable(
                navController = navController,
                donation = donationList[index],
                onItemClicked
            )
        }
    }
}