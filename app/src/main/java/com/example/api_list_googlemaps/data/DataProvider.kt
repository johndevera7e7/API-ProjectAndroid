package com.example.api_list_googlemaps.data

import androidx.compose.remote.creation.compose.state.log
import com.example.api_list_googlemaps.model.Collection
import com.example.api_list_googlemaps.model.Data
import com.example.api_list_googlemaps.model.Item
import com.example.api_list_googlemaps.network.ApiService
import com.example.api_list_googlemaps.network.RetrofitClient

class DataProvider {
    suspend fun getDataNASA(): List<Data> {
        return try {
            val response = RetrofitClient.instance.getData()
            if (response.isSuccessful) {
                response.body()?.items ?: listOf(Data(emptyList(),emptyList(),"No data found", emptyList(), "",""))
            } else {
                listOf(Data(emptyList(),emptyList(),"No response", emptyList(), "",""))
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}