package com.example.single

import com.example.base.ui.DetailsPhoto

data class DetailsState(
    val isLoading : Boolean = false,
    val photoDetails : List<DetailsPhoto> = emptyList(),
    val error: String = ""
)