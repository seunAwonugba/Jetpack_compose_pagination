package com.example.details.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.repository.DetailsPhotoRepository
import com.example.base.ui.DetailsPhoto
import com.example.details.Resource
import com.example.details.updateValue
import com.example.details.wrapAsResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: DetailsPhotoRepository,
//    private val savedStateHandle: SavedStateHandle
)  : ViewModel() {

//    private val userId: String?
//        get() = savedStateHandle["userId"]

    private val _state = MutableStateFlow(State())
    internal val state: StateFlow<State> = _state

    init {
//        fetchPhotoDetails()
    }

//    private fun fetchPhotoDetails() {
//        repository
//            .getPhoto(userId = userId.toString())
//            .wrapAsResource()
//            .onEach { _state.updateValue { copy(photoDetailsRes = it) } }
//            .launchIn(viewModelScope)
//    }

    companion object {
        internal data class State(
            val photoDetailsRes: Resource<DetailsPhoto> = Resource.initial()
        )
    }


}