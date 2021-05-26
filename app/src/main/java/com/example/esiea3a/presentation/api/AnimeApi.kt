package com.example.esiea3a.presentation.api


import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path


interface AnimeApi {
    //https://api.jikan.moe/v3/anime/{id}(/request)
    // https://api.jikan.moe/v3/search/anime?q=no game no life
    //https://api.jikan.moe/v3/anime/1/pictures
    //36884
    @GET ("search/anime?q=high")
    fun getAnimeList(): Call<AnimeResponse>

    @GET("anime/{id}")
    fun getAnimeDetail(@Path("id") id: Int): Call<AnimeDetailResponse>
}

