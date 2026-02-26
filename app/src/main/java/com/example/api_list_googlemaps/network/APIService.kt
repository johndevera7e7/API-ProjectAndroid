package com.example.api_list_googlemaps.network

import com.example.api_list_googlemaps.model.Collection
import com.example.api_list_googlemaps.model.Item
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("search?q=orion&page=1&media=image,video,audio&yearStart=1920&yearEnd=2026") //Aqui tienes el problema
    suspend fun getData(): Response<Collection>

}