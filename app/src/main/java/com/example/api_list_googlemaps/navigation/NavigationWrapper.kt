package com.example.api_list_googlemaps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.api_list_googlemaps.model.Data
import com.example.api_list_googlemaps.model.Item
import com.example.api_list_googlemaps.view.DetailScreen
import com.example.api_list_googlemaps.view.FavouritesScreen
import com.example.api_list_googlemaps.view.ListScreen
import com.example.api_list_googlemaps.view.SettingsScreen
import com.example.api_list_googlemaps.viewmodel.GameViewModel

@Composable
fun NavigationWrapper(navController: NavHostController) {
    var selectedNASAItem by remember { mutableStateOf<Data?>(null) }
    NavHost(navController = navController, startDestination = Destinations.ListScreen) {
        composable<Destinations.ListScreen> {
            ListScreen(
                viewModel = viewModel(),
                onNavegarAlDetall = { NasaProducte ->
                    navController.navigate(Destinations.DetailScreen(ItemName = ""))
                }
            )
        }

        composable<Destinations.FavouritesScreen> {
            FavouritesScreen()
        }

        composable<Destinations.SettingsScreen> {
            SettingsScreen()
        }

        composable<Destinations.DetailScreen> { backStackEntry ->
            DetailScreen(
                viewModel = viewModel(),
                item = selectedNASAItem!!,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
