package com.movies.repo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val backDropPath: String,
    val genreIds: List<Int>,
    val title: String,
    val posterPath: String,
    val adult: Boolean,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val releaseDate: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Double
) : Parcelable