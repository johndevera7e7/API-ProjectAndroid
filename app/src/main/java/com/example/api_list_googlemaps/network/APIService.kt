package com.example.api_list_googlemaps.network

import com.example.api_list_googlemaps.model.NasaApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("search?q=nebula&media_type=image")
    suspend fun getData(): Response<NasaApiResponse>

}