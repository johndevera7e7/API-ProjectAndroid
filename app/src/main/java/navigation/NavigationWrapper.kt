package navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.api_list_googlemaps.view.DetailScreen
import com.example.api_list_googlemaps.view.FavouritesScreen
import com.example.api_list_googlemaps.view.ListScreen
import com.example.api_list_googlemaps.view.SettingsScreen

@Composable
fun NavigationWrapper(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.ListScreen) {
        composable<Destinations.ListScreen> {
            ListScreen(
                onNavegarAlDetall = { nomDelProducte ->
                    navController.navigate(Destinations.DetailScreen(nomDetail = nomDelProducte))
                },
                viewModel = viewModel()
            )
        }

        composable<Destinations.FavouritesScreen> {
            FavouritesScreen()
        }

        composable<Destinations.SettingsScreen> {
            SettingsScreen()
        }

        composable<Destinations.DetailScreen> { backStackEntry ->
            val ruta = backStackEntry.toRoute<Destinations.DetailScreen>()

            DetailScreen(
                nom = ruta.nomDetail,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
