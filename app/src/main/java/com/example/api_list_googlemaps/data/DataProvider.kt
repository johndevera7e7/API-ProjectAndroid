package com.example.api_list_googlemaps.data

import com.example.api_list_googlemaps.model.Item
import com.example.api_list_googlemaps.network.RetrofitClient

class DataProvider {
    suspend fun getDataNASA(): List<Item> {
        return try {
            val response = RetrofitClient.instance.getData()
            response.body()?.collection?.items ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}

