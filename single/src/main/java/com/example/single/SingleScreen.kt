package com.example.single

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.single.components.ErrorItem
import com.example.single.components.Header

@Composable
fun SingleScreen(
    viewModel: SingleViewModel = hiltViewModel(),
    navBack : () -> Unit

) {

    val state = viewModel.state.value
    val err = state.error
    val userId = viewModel.userId

    when{
        state.photoDetails!=null -> {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Header(fullName = state.photoDetails.name) {
                    navBack()
                }
            }
        }

        state.error.isNotEmpty() -> {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Header(fullName = "") {
                        navBack()
                    }
                    Box(
                        modifier = Modifier.fillMaxSize(),
//                            .background(Color.Red),
                        contentAlignment = Alignment.Center
                    ) {
                        ErrorItem(
                            errorMessage = err
                        ) { viewModel.getPhotoDetails(userId = userId.toString()) }
                    }
                }
            }
        }

        state.isLoading -> {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Header(fullName = "") {
                        navBack()
                    }

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}