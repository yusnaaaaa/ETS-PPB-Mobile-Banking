package com.example.mobilebanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebanking.ui.theme.LightOrange
import com.example.mobilebanking.ui.theme.LightGrey
import com.example.mobilebanking.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pin(navController: NavController) {
    var pin by remember {
        mutableStateOf(TextFieldValue())
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
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.padding(120.dp))

            Text(
                text = "PIN ATM",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                style = TextStyle(color = Orange)
            )

            Spacer(modifier = Modifier.padding(16.dp))

            // Input PIN (6 digits)
            TextField(
                value = pin,
                onValueChange = {
                    if (it.text.length <= 6) {
                        pin = it
                    }
                },
                label = { Text("Enter Your PIN") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                visualTransformation = PasswordVisualTransformation(),
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

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    if (pin.text.length == 6) {
                        navController.navigate(Routes.Verification)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Transfer",
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
