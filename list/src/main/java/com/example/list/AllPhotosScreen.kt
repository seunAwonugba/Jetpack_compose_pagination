package com.example.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.list.component.AllPhotosListItem
import com.example.list.component.SearchBar
import com.example.list.viewmodel.AllPhotosViewModel

@Composable
fun AllPhotosScreen(
    navController : NavController,
    allPhotosViewModel: AllPhotosViewModel = hiltViewModel()
){
    val getAllPhotos = allPhotosViewModel.getAllPhotos.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = PaddingValues(horizontal = 16.dp)),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(8.dp))

            SearchBar(modifier = Modifier.fillMaxWidth()) {
                val query = it.text
                if (query.isNotEmpty()){
                    allPhotosViewModel.searchQuery
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ){
                items(items = getAllPhotos, key = { it.id }){ listItem ->
                    if (listItem != null) {
                        AllPhotosListItem(
                            allPhotosData = listItem,
                            onClickToDetails = {}
                        )
                    }
                }
            }
        }
    }


}
