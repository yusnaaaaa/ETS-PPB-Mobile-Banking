package com.example.mobilebanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebanking.ui.theme.LightGrey
import com.example.mobilebanking.ui.theme.LightOrange
import com.example.mobilebanking.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavController) {
    val adImages = listOf(
        R.drawable.ad_image_1,
        R.drawable.ad_image_2,
        R.drawable.ad_image_3,
        R.drawable.ad_image_4,
        R.drawable.ad_image_5,
        R.drawable.ad_image_6,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Dashboard",
                    color = Orange,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle navigation icon click */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.bni_logo),
                        contentDescription = "Login image",
                        modifier = Modifier.size(200.dp)
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* Handle profile icon click */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_icon),
                        contentDescription = "Profile image",
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bagian Welcome Section
        WelcomeSection(userName = "Yusna Millaturrosyidah", balance = "Rp 10.000.000")

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Baris 1
            Button(
                onClick = {
                    navController.navigate(Routes.Transfer)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightOrange,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(80.dp)
                    .padding(end = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.transfer_1),
                        contentDescription = "Transfer Icon",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Transfer",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }

            Button(
                onClick = {
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightOrange,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(80.dp)
                    .padding(end = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.transfer_2),
                        contentDescription = "Payment Icon",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Virtual Account",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Baris 2
            Button(
                onClick = {
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightOrange,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(80.dp)
                    .padding(end = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.transfer_3),
                        contentDescription = "Data Icon",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Pulsa / Data",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }

            Button(
                onClick = {
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightOrange,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(80.dp)
                    .padding(end = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.transfer_4),
                        contentDescription = "Other Icon",
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Other",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LazyRow untuk iklan
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            items(adImages) { adImage ->
                Image(
                    painter = painterResource(id = adImage),
                    contentDescription = "Advertisement",
                    modifier = Modifier
                        .size(300.dp, 200.dp)
                )
            }
        }
    }
}

@Composable
fun WelcomeSection(userName: String, balance: String) {
    var showBalance by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(215.dp)
            .padding(30.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Welcome!",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = userName,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (showBalance) {
                Text(
                    text = "Saldo: $balance",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            } else {
                Text(
                    text = "Saldo: ****",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { showBalance = !showBalance },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGrey,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = if (showBalance) "Hide" else "Show",
                    color = Color.Black
                )
            }
        }
    }
}

