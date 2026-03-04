package com.example.api_list_googlemaps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.api_list_googlemaps.model.Item
import com.example.api_list_googlemaps.navigation.Destinations
import com.example.api_list_googlemaps.navigation.NavigationItem
import com.example.api_list_googlemaps.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                MyApp()
            }

        }

    }
}

@Composable
fun MyApp() {
    var selectedNASAItem by remember { mutableStateOf<Item?>(null) }
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(
        NavigationItem("List", Icons.Default.Home, Destinations.ListScreen, 0),
        NavigationItem("Favourites", Icons.Default.Person, Destinations.FavouritesScreen, 1),
        NavigationItem("Settings", Icons.Default.Settings, Destinations.SettingsScreen, 2)
    )
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = item.index == selectedItem,
                    label = { Text(item.label) },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                    onClick = {
                        selectedItem = index
                        navController.navigate(item.route)
                    }
                )
            }
        }
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationWrapper(navController)
        }
    }
}