package com.example.jetpackcomposepagination.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.jetpackcomposepagination.navigation.Screens

@Composable
fun GlobalScaffold(
    scaffoldState: ScaffoldState,
    currentRoute: String?,
    onClickNavUp : () -> Unit,
    content: @Composable (
        paddingValues: PaddingValues, onTitleChanged: (newTitle: String) -> Unit
    ) -> Unit,
) {
    var title by rememberSaveable { mutableStateOf("") }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            val showTopAppBar = !listOf(
                Screens.AllPhotosScreen.route
            ).contains(currentRoute)

            if (!showTopAppBar) return@Scaffold

            GlobalTopAppBar(title = title) {
                onClickNavUp()
            }
        },
    ) { paddingValues -> content(paddingValues) { newTitle -> title = newTitle } }
}