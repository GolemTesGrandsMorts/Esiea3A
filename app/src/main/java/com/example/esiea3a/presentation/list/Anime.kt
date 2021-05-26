package com.example.esiea3a.presentation.list

data class Anime (
    val request_hash:String,
    val request_cached: Boolean,
    val request_cache_expiry: Int,
    val mal_id: Int,
    val image_url: String,
    val title:String,
    val synopsis:String)

