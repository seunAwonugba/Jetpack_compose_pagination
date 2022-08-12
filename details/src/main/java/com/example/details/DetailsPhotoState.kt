package com.example.details

import com.example.base.ui.DetailsPhoto


data class DetailsPhotoState(
    val error: Throwable?,
    val detailsPhoto: List<DetailsPhoto>?,
    val loadingState: LoadingState
){
    companion object {
        fun init() = DetailsPhotoState(null, null, loadingState = LoadingState.Idle)
    }

    sealed class LoadingState {
        object Idle : LoadingState()
        object Working : LoadingState()
        object Error : LoadingState()
        object FetchSuccess : LoadingState()
    }
}
