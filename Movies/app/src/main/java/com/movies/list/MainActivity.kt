package com.movies.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.movies.R
import com.movies.details.MovieDetailActivity
import com.movies.repo.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MovieViewModel
    private val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        adapter.onTapListener = onItemTap
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.nowPlayingMovies.observe(this, this::onItems)
        viewModel.getNowPlayingMovies()
    }

    private fun onItems(items: List<Movie>) {
        adapter.items(items)
    }

    private val onItemTap = MovieAdapter.OnItemTap {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("movie", it)
        startActivity(intent)
    }
}