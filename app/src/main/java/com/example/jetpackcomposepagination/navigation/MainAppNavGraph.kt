package com.example.jetpackcomposepagination.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.details.DetailsPhotoScreen
import com.example.list.AllPhotosScreen

@Composable
fun MainAppNavGraph(
    navController: NavHostController,
    onTitleChange: (String) -> Unit
){
    NavHost(
        navController = navController,
        startDestination = Screens.AllPhotosScreen.route
    ){
        composable(route = Screens.AllPhotosScreen.route){
            AllPhotosScreen{ id->
                navController.navigate("${Screens.SinglePhotoScreen.route}")
            }
        }
        composable(route = "${Screens.SinglePhotoScreen.route}"){
            DetailsPhotoScreen()
            onTitleChange("Image Details")
        }
    }

}