package com.example.mobilebanking

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mobilebanking.ui.theme.Orange
import com.example.mobilebanking.ui.theme.Tosca

@Composable
fun Login(navController: NavHostController) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.bni_logo),
            contentDescription = "Login image",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login to your account!")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label = {
            Text(text = "User ID")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = {
            Text(text = "MPIN")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(Routes.Dashboard)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Tosca,
                contentColor = Color.White
            ),
            modifier = Modifier.size(width = 300.dp, height = 50.dp)
        ) {
            Text(text = "Login")
        }

            Spacer(modifier = Modifier.height(16.dp))


            TextButton(onClick = { }) {
                Text(text = "Forgot MPIN?", color = Orange)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Or sign in with")


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(painter = painterResource(id = R.drawable.twitter),
                    contentDescription = "Login image",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {

                        })

                Image(painter = painterResource(id = R.drawable.google),
                    contentDescription = "Login image",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {

                        })
                Image(painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Login image",
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {

                        })
            }

        }
    }

