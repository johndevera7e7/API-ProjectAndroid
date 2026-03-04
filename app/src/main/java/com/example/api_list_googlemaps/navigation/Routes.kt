package com.example.api_list_googlemaps.navigation

import com.example.api_list_googlemaps.model.Data
import com.example.api_list_googlemaps.model.Item
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object ListScreen: Destinations()
    @Serializable
    object FavouritesScreen:Destinations()
    @Serializable
    object SettingsScreen:Destinations()
    @Serializable
    data class DetailScreen(val ItemName: String): Destinations()
}