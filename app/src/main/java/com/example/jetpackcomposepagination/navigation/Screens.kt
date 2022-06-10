package com.example.jetpackcomposepagination.navigation

sealed class Screens(val route : String){
    object AllPhotosScreen : Screens("list_screen")
    object SinglePhotoScreen : Screens("details_screen")
}
