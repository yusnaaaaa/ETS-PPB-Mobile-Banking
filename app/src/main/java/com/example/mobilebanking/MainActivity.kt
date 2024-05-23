package com.example.mobilebanking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.Login, builder ={
                composable(Routes.Login){
                    Login(navController)
                }
                composable(Routes.Dashboard){
                    Dashboard(navController)
                }
                composable(Routes.Transfer){
                    Transfer(navController)
                }
                composable(Routes.Pin){
                    Pin(navController)
                }
                composable(Routes.Verification){
                    Verification(navController)
                }
            })
        }
    }
}

