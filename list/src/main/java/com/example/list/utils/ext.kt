package com.example.list.utils

import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

val LazyPagingItems<*>.isLoading: Boolean
    get() = loadState.refresh == LoadState.Loading

val LazyPagingItems<*>.isRefreshing: Boolean
    get() = isLoading && itemCount > 0

val LazyPagingItems<*>.isEmpty: Boolean
    get() = loadState.append.endOfPaginationReached && itemCount == 0

val LazyPagingItems<*>.isError: Boolean
    get() = loadState.refresh is LoadState.Error