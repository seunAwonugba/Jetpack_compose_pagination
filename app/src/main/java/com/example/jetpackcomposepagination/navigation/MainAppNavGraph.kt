package com.example.jetpackcomposepagination.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainAppNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.AllPhotosScreen.route){
        composable(route = Screens.AllPhotosScreen.route){

        }
        composable(route = Screens.SinglePhotoScreen.route){

        }
    }

}