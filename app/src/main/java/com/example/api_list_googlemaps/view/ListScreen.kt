package com.example.api_list_googlemaps.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.api_list_googlemaps.component.NasaItem
import com.example.api_list_googlemaps.model.Data
import com.example.api_list_googlemaps.model.Item
import com.example.api_list_googlemaps.viewmodel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    viewModel: GameViewModel,
    nasa: Data,
    onNavegarAlDetall: (Data) -> Unit
) {
    var selectedItem by remember { mutableStateOf<Item?>(null)}
    Scaffold(
        topBar = { TopAppBar(title = { Text("NASA API") }) }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            if (viewModel.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn() {
                    items(viewModel.nasaList) { item ->
                        NasaItem(
                            item,
                            onItemClick = { onNavegarAlDetall(nasa) }
                        )




                    }
                }
            }
        }
    }
}
