package com.example.api_list_googlemaps.model

data class Collection(
    val href: String,
    val items: List<Data>,
    val links: List<LinkX>,
    val metadata: Metadata,
    val version: String
)




