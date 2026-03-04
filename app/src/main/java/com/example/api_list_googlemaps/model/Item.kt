package com.example.api_list_googlemaps.model


data class Item(
    val `data`: List<Data>,
    val href: String,
    val links: List<Link>
)