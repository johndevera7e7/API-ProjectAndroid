package com.example.api_list_googlemaps.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.api_list_googlemaps.data.DataProvider
import com.example.api_list_googlemaps.model.Collection
import com.example.api_list_googlemaps.model.Data
import com.example.api_list_googlemaps.model.Item
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.emptyList

class GameViewModel : ViewModel() {
    private val repository = DataProvider()
    var nasaList: List<Data> by mutableStateOf(emptyList()) //: List<Item>
    var isLoading by mutableStateOf(false)
    private set

    init{
        fetchNasaData()
    }

    fun fetchNasaData() {
        viewModelScope.launch {
            isLoading = true
            nasaList = repository.getDataNASA()
            isLoading = false
        }
    }
}