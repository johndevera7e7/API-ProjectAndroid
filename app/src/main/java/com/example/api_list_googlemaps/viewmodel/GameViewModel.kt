package com.example.api_list_googlemaps.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_list_googlemaps.data.DataProvider
import com.example.api_list_googlemaps.model.Data
import com.example.api_list_googlemaps.model.Item
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class GameViewModel : ViewModel() {
    private val repository = DataProvider()
    var nasaList: List<Item> by mutableStateOf(emptyList())
    var nasaDataList: List<Data> by mutableStateOf(emptyList())
    var isLoading by mutableStateOf(false)
    private set

    init {
        fetchNasaData()
    }

    fun fetchNasaData() {
        viewModelScope.launch {
            try {
                isLoading = true
                nasaList = repository.getDataNASA()
                nasaDataList = nasaList.flatMap { it.data }
                isLoading = false
            } catch (e: Exception) {
                isLoading = false
            }
        }
    }
}