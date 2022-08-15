package com.example.single

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.base.ui.DetailsPhoto

@Composable
fun SingleScreen(
    viewModel: SingleViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    Log.e("STATE_VALUE", state.photoDetails.toString())

    LazyColumn {
        items(state.photoDetails){ fetchesItems ->
            FetchedDataItem(data = fetchesItems)
        }
    }


}

@Composable
fun FetchedDataItem(
    data : DetailsPhoto
) {
    Column {
        Text(text = data.id)
        Text(text = data.name)
    }
    
}