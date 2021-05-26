package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.api.AnimeApi
import com.example.esiea3a.presentation.api.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = AnimeAdapter(listOf(), ::onClikedAnime)

    private  val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_anime_list, container,false )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.anime_recyclerview)



        recyclerView.apply {
            layoutManager = this@AnimeListFragment.layoutManager
            adapter=this@AnimeListFragment.adapter
        }

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val animeApi: AnimeApi = retrofit.create(AnimeApi::class.java)

        animeApi.getAnimeList().enqueue(object: Callback<AnimeResponse> {
            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val animeResponse : AnimeResponse = response.body()!!
                    adapter.updateList(animeResponse.results)
                }
            }
        })

        /*val animeList : ArrayList<Anime> = arrayListOf<Anime>().apply {
            add(Anime("Yugioh","Yugioh"))
            add(Anime("Pokemon","Pokemon"))
            add(Anime("SAO","SAO"))
            add(Anime("SNK","SNK"))
            add(Anime("NGNL","NGNL"))
            add(Anime("DBZ","DBZ"))
        }
        adapter.updateList(animeList)*/
    }
    private fun onClikedAnime(anime: Anime) {
        findNavController().navigate(R.id.navigateToAnimeDetailFragment)
    }
}


