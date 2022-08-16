package com.example.list

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.list.component.AllPhotosListItem
import com.example.list.component.ErrorItem
import com.example.list.component.SearchBar
import com.example.list.viewmodel.AllPhotosViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AllPhotosScreen(
    allPhotosViewModel: AllPhotosViewModel = hiltViewModel(),
    navToDetailsScreen : (String) -> Unit,
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
//                val query = it.text
//                if (query.isNotEmpty()){
//                    allPhotosViewModel.searchQuery
//                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ){
                items(
                    items = getAllPhotos,
                    key = { it.id }
                ){ listItem ->
                    if (listItem != null) {
                        AllPhotosListItem(
                            allPhotosData = listItem,
                            onClickToDetails = {
                                navToDetailsScreen(listItem.id)
                            }
                        )
                    }
                }

                getAllPhotos.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            //You can add modifier to manage load state when first time response page is loading
                            item { FirstTimeLoadingView(modifier = Modifier.fillParentMaxSize()) }
                        }
                        loadState.append is LoadState.Loading -> {
                            //You can add modifier to manage load state when next response page is loading
                            item { FetchNextResponseLoadingView(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) }
                        }
                        loadState.refresh is LoadState.Error -> {
                            val err = getAllPhotos.loadState.refresh as LoadState.Error
                            item {
                                Box(
                                    modifier = Modifier.fillParentMaxSize(),
                                    contentAlignment = Alignment.Center
                                ){
                                    ErrorItem(
                                        errorMessage = err.error.message.toString(),
                                        retry = { retry() }
                                    )
                                }
                            }
                        }
                        loadState.append is LoadState.Error -> {
                            val err = getAllPhotos.loadState.append as LoadState.Error
                            Log.e("ERROR2", err.error.toString())

                            item {
                                Box(
                                    modifier = Modifier.fillParentMaxSize(),
                                    contentAlignment = Alignment.Center
                                ){
                                    ErrorItem(
                                        errorMessage = err.error.localizedMessage!!,
                                        retry = { retry() }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FirstTimeLoadingView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun FetchNextResponseLoadingView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}