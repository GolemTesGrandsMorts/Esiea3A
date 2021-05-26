package com.example.esiea3a.presentation.api

import com.example.esiea3a.presentation.list.Anime

data class AnimeResponse (val request_hash:String, val request_cached: Boolean, val request_cache_expiry: Int, val results: List<Anime>)