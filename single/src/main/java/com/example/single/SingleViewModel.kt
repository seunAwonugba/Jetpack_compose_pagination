package com.example.single

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.resource.Resource
import com.example.single.usecase.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SingleViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(DetailsState())
    internal val state: State<DetailsState> = _state

    private val userId: String?
        get() = savedStateHandle["userId"]

    init {
        getPhotoDetails(userId = userId.toString())
    }

    private fun getPhotoDetails(userId : String){
        detailsUseCase(userId = userId)
            .onEach { data ->
                when(data){
                    is Resource.Success -> {
                        _state.value = DetailsState(photoDetails = data.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = DetailsState(error = data.message.toString())
                    }
                    is Resource.Loading -> {
                        _state.value = DetailsState(isLoading = true)

                    }
                }
        }.launchIn(viewModelScope)
    }
}