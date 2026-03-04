package com.example.api_list_googlemaps.model

data class NasaApiResponse(
    val collection: Collection
)

data class Collection(
    val href: String,
    val items: List<Item>,
    val links: List<LinkX>,
    val metadata: Metadata,
    val version: String
)