package edu.put.inf151764.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import edu.put.inf151764.*
import edu.put.inf151764.view.data.Games
import edu.put.inf151764.view.list.GamesAdapter
import edu.put.inf151764.view.list.GamesRecyclerViewListener
import edu.put.inf151764.viewmodel.GamesViewModel
import edu.put.inf151764.viewmodel.MainViewModel

@AndroidEntryPoint
class GamesActivity : AppCompatActivity(), GamesRecyclerViewListener {

    private val viewModel: GamesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val recyclerViewGames = findViewById<RecyclerView>(R.id.gamesRecyclerView)
        var gamesList = mutableListOf(
            Games("Chińczyk", "847467", "2008", "6353", "rewvew"),
            Games("Szachy", "245657", "2010", "353", "ewvwre"),
            Games("Monopoly", "34562", "2006", "2", "wqfvqr")
        )

        val adapter = GamesAdapter(gamesList, this)
        recyclerViewGames.adapter = adapter
        recyclerViewGames.layoutManager = LinearLayoutManager(this)

    }
    override fun onItemClick(position: Int) {
        // Handle the item click event
        // Start the new activity or perform any other action
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }
}