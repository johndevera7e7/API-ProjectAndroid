package navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object ListScreen: Destinations()
    @Serializable
    object FavouritesScreen:Destinations()
    @Serializable
    object SettingsScreen:Destinations()
    @Serializable
    data class DetailScreen(val nomDetail: String) : Destinations()
}