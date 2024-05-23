package com.example.mobilebanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebanking.ui.theme.LightGrey
import com.example.mobilebanking.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Transfer(navController: NavController) {

    val accountNumber = remember { mutableStateOf("") }
    val bankName = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val saveAccountNumber = remember { mutableStateOf(false) }

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

//        Spacer(modifier = Modifier.padding(10.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(10.dp))

            // Title "Transfer"
            Text(
                text = "Transfer",
                modifier = Modifier.padding(16.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(color = Orange)
            )

            // Input Nama Bank
            Text(
                text = "Bank Name",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp),
            )

            TextField(
                value = bankName.value,
                onValueChange = { bankName.value = it },
                label = { Text("Enter The Bank Name") },
                singleLine = true,
                modifier = Modifier.padding(bottom = 16.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = LightGrey,
                    focusedContainerColor = LightGrey,
                    focusedIndicatorColor = Orange,
                    unfocusedIndicatorColor = Orange,
                    focusedLabelColor = Orange,
                    cursorColor = Orange
                )
            )

            // Input Nomor Rekening
            Text(
                text = "Account Number",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp),
            )

            TextField(
                value = accountNumber.value,
                onValueChange = { accountNumber.value = it },
                label = { Text("Enter Your Account Number") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.padding(bottom = 16.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = LightGrey,
                    focusedContainerColor = LightGrey,
                    focusedIndicatorColor = Orange,
                    unfocusedIndicatorColor = Orange,
                    focusedLabelColor = Orange,
                    cursorColor = Orange
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Checkbox(
                    checked = saveAccountNumber.value,
                    onCheckedChange = { saveAccountNumber.value = it },
                    colors = CheckboxDefaults.colors(checkedColor = Orange)
                )
                Text(
                    text = "Save Account Number",
                    modifier = Modifier.padding(start = 8.dp),
                    fontSize = 16.sp
                )
            }

            // Input Nominal
            Text(
                text = "Nominal",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )

            TextField(
                value = amount.value,
                onValueChange = { amount.value = it },
                label = { Text("Nominal") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.padding(bottom = 16.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = LightGrey,
                    focusedContainerColor = LightGrey,
                    focusedIndicatorColor = Orange,
                    unfocusedIndicatorColor = Orange,
                    focusedLabelColor = Orange,
                    cursorColor = Orange
                )
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = {
                    navController.navigate(Routes.Pin)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Next",
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