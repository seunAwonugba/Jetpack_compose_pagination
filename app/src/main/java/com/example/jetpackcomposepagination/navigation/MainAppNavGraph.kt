package com.example.jetpackcomposepagination.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.details.SinglePhotoScreen
import com.example.list.AllPhotosScreen

@Composable
fun MainAppNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.AllPhotosScreen.route){
        composable(route = Screens.AllPhotosScreen.route){
            AllPhotosScreen(navController = navController)
        }
        composable(route = Screens.SinglePhotoScreen.route){
            SinglePhotoScreen()

        }
    }

}