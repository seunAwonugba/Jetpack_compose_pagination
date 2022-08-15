package com.example.list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.example.base.repository.AllPhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AllPhotosViewModel @Inject constructor(
    allPhotosRepository: AllPhotosRepository
) : ViewModel(){
    var searchQuery by mutableStateOf(TextFieldValue(""))

    val getAllPhotos = allPhotosRepository.getAllPhotos()




}