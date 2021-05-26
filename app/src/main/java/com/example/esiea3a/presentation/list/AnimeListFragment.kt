package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.Singletons
import com.example.esiea3a.presentation.api.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = AnimeAdapter(listOf(), ::onClickedAnime)
   // private  val layoutManager = LinearLayoutManager(context)

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
            layoutManager = LinearLayoutManager(context)
            adapter=this@AnimeListFragment.adapter
        }

        Singletons.animeApi.getAnimeList().enqueue(object: Callback<AnimeResponse> {
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
    }
    private fun onClickedAnime(anime: Anime) {
        findNavController().navigate(R.id.navigateToAnimeDetailFragment, bundleOf(
            "animeId" to anime.mal_id
        ))

    }
}


