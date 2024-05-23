package com.example.mobilebanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebanking.ui.theme.Orange

data class TransferHistoryItem(val bankName: String, val accountNumber: String, val amount: String, val date: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Verification(navController: NavController) {
    // Dummy transfer history data
    val transferHistory = remember {
        listOf(
            TransferHistoryItem(
                "Bank Rakyat Indonesia",
                "1234567890",
                "Rp 1,000,000",
                "06-05-2024"
            ),
            TransferHistoryItem("Bank Central Asia", "0987654321", "Rp 500,000", "18-05-2024"),
            TransferHistoryItem("Bank Mandiri", "1122334455", "Rp 2,000,000", "15-05-2024")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        TopAppBar(
            title = {
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Transfer Successfully!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                style = TextStyle(color = Orange)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Image
            Image(
                painter = painterResource(R.drawable.ceklis),
                contentDescription = "Transfer Success Icon",
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Latest Transfer Summary
            Text(
                text = "Latest Transfer",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(color = Orange)
            )

            TransferSummaryView(transferHistory.first())

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate(Routes.Login)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = Color.White
                ),
            ) {
                Text(
                    text = "Done",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(228.dp)
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun TransferSummaryView(transferItem: TransferHistoryItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = " ${transferItem.bankName}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = "Account Number: ${transferItem.accountNumber}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = "Amount: ${transferItem.amount}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = "Date: ${transferItem.date}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

