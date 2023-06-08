package edu.put.inf151764

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var viewModel: GamesViewModel

class GamesActivity : AppCompatActivity(), GamesRecyclerViewListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        viewModel = ViewModelProvider(this).get(GamesViewModel::class.java)

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