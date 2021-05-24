package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = AnimeAdapter(listOf())
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
        val animeList : ArrayList<Anime> = arrayListOf<Anime>().apply {
            add(Anime("Yugioh"))
            add(Anime("Pokemon"))
            add(Anime("SAO"))
            add(Anime("SNK"))
            add(Anime("NGNL"))
            add(Anime("DBZ"))
        }
        adapter.updateList(animeList)
    }

}