package com.example.jetpackcomposepagination.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.list.AllPhotosScreen
import com.example.single.SingleScreen

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
                navController.navigate("${Screens.SinglePhotoScreen.route}/$id")
            }
        }
        composable(route = "${Screens.SinglePhotoScreen.route}/{userId}"){
//            onTitleChange("Image Details")
            SingleScreen{
                navController.navigateUp()
            }
        }
    }
}