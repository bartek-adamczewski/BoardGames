package edu.put.inf151764.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.put.inf151764.R
import edu.put.inf151764.view.data.Games

class GamesAdapter(var games: List<Games>, private val clickListener: GamesRecyclerViewListener) : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    inner class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val position = adapterPosition
            clickListener.onItemClick(position)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_recycler_view_layout, parent, false)
        return GamesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val currentItem = games.get(position)
        val title = holder.itemView.findViewById<TextView>(R.id.gamesTitle)
        val id = holder.itemView.findViewById<TextView>(R.id.gamesId)
        val year = holder.itemView.findViewById<TextView>(R.id.gamesYear)
        val rank = holder.itemView.findViewById<TextView>(R.id.gamesRank)
        title.setText("Tytuł: ${currentItem.title}")
        id.setText("Id: ${currentItem.id}")
        year.setText("Rok: ${currentItem.year}")
        rank.setText("Ranga: ${currentItem.rank}")
    }
}