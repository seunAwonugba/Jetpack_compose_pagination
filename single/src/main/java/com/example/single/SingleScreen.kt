package com.example.single

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.single.components.ErrorItem
import com.example.single.components.Header

@OptIn(ExperimentalCoilApi::class)
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
                Column {
                    Header(fullName = state.photoDetails.name) {
                        navBack()
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        val painter = rememberImagePainter(data = state.photoDetails.profileImage)
                        val painterState = painter.state
                        Image(
                            painter = painter,
                            contentDescription = state.photoDetails.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(120.dp).align(Alignment.Center).clip(CircleShape)
                        )
                        if (painterState is ImagePainter.State.Loading){
                            CircularProgressIndicator(
                                color = MaterialTheme.colors.primary,
                                modifier = Modifier.scale(.5f)
                            )
                        }
                    }

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