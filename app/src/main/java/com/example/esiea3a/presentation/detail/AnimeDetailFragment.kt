package com.example.esiea3a.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.Singletons
import com.example.esiea3a.presentation.api.AnimeDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AnimeDetailFragment : Fragment() {

    private lateinit var textViewName :TextView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_anime_detail,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById((R.id.anime_detail_name))
        callApi()
    }


    private fun callApi(){
        val id = arguments?.getInt("animeId") ?:-1
        Singletons.animeApi.getAnimeDetail(id).enqueue(object : Callback<AnimeDetailResponse> {
            override fun onFailure(call: Call<AnimeDetailResponse>, t: Throwable) {

        }
            override fun onResponse(call: Call<AnimeDetailResponse>, response: Response<AnimeDetailResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    textViewName.text = response.body()!!.synopsis
                }
            }
        })
    }
}
