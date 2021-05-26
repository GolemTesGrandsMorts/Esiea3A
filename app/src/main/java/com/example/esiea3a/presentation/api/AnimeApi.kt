package com.example.esiea3a.presentation.api


import retrofit2.http.GET
import retrofit2.Call


interface AnimeApi {
    //https://api.jikan.moe/v3/anime/{id}(/request)
    // https://api.jikan.moe/v3/search/anime?q=no game no life
    //https://api.jikan.moe/v3/anime/1/pictures
    @GET ("search/anime?q=high")
    fun getAnimeList(): Call<AnimeResponse>
}

