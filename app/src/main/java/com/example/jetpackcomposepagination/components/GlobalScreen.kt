package com.example.jetpackcomposepagination.components

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposepagination.navigation.MainAppNavGraph

@Composable
fun GlobalScreen() {
    val navController = rememberNavController()


    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route


    GlobalScaffold(
        scaffoldState = scaffoldState,
        currentRoute = currentRoute,
        onClickNavUp = {
            navController.navigateUp()
        }
    ){ _, onTitleChanged ->
        MainAppNavGraph(
            navController = navController,
            onTitleChange = onTitleChanged
        )
    }

}