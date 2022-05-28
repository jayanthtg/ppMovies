package com.movies.details

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.movies.R
import com.movies.repo.model.Movie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var poster: ImageView
    private lateinit var ratingsText: TextView
    private lateinit var popularityText: TextView
    private lateinit var releaseDateText: TextView
    private lateinit var overviewText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        poster = findViewById(R.id.poster)
        ratingsText = findViewById(R.id.ratingTv)
        popularityText = findViewById(R.id.popularityTv)
        releaseDateText = findViewById(R.id.releaseDateTv)
        overviewText = findViewById(R.id.overviewTv)
        bindMovie()
    }

    private fun bindMovie() {
        val movie = intent.getParcelableExtra<Movie>("movie") ?: return
        Glide.with(poster).load(movie.posterPath).into(poster)
        releaseDateText.text = movie.releaseDate
        ratingsText.text = movie.voteAverage.toString()
        popularityText.text = movie.popularity.toString()
        overviewText.text = movie.overview
    }
}