package com.example.esiea3a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R

class AnimeAdapter(private var dataSet: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.ViewHolder>() {
    private var listener:((Anime)-> Unit)? =null
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.anime_name)

        }
    }
    fun updateList(List: List<Anime>){
        dataSet = List
        notifyDataSetChanged()
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.anime_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val anime:Anime =dataSet[position]
        viewHolder.textView.text = anime.title
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(anime)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}