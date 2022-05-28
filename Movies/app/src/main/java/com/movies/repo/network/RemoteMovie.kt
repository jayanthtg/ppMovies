package com.movies.repo.network

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RemoteMovie(
    @SerializedName("dates") private val dates: Date?,
    @SerializedName("page") private val page: Int?,
    @SerializedName("results") private val results: List<Result>?,
    @SerializedName("total_pages") private val totalPages: Int?,
    @SerializedName("total_results") private val totalResults: Int?
) {

    fun dates(): Date = dates ?: Date(null, null)
    fun page(): Int = page ?: 0
    fun results(): List<Result> = results ?: listOf()
    fun totalPages(): Int = totalPages ?: 0
    fun totalResults(): Int = totalResults ?: 0

    data class Date(
        @SerializedName("maximum") private val maximum: String?,
        @SerializedName("minimum") private val minimum: String?
    ) {
        fun maximum(): String = maximum ?: String()
        fun minimum(): String = minimum ?: String()
    }

    data class Result(
        @SerializedName("id") private val id: Int?,
        @SerializedName("backdrop_path") private val backDropPath: String?,
        @SerializedName("genre_ids") val genreIds: List<Int>?,
        @SerializedName("title") private val title: String?,
        @SerializedName("poster_path") private val posterPath: String?,
        @SerializedName("adult") private val adult: Boolean?,
        @SerializedName("original_language") private val originalLanguage: String?,
        @SerializedName("original_title") private val originalTitle: String?,
        @SerializedName("overview") private val overview: String?,
        @SerializedName("popularity") private val popularity: Double?,
        @SerializedName("release_date") private val releaseDate: String?,
        @SerializedName("video") private val video: Boolean?,
        @SerializedName("vote_average") private val voteAverage: Double?,
        @SerializedName("vote_count") private val voteCount: Double?
    ) {
        fun id(): Int = id ?: 0
        fun backDropPath(): String = backDropPath ?: String()
        fun genreIds(): List<Int> = genreIds ?: listOf()
        fun title(): String = title ?: String()
        fun posterPath(): String = posterPath ?: String()
        fun adult(): Boolean = adult ?: false
        fun originalLanguage(): String = originalLanguage ?: String()
        fun originalTitle(): String = originalTitle ?: String()
        fun overview(): String = overview ?: String()
        fun popularity(): Double = popularity ?: 0.0
        fun releaseDate(): String = releaseDate ?: String()
        fun video(): Boolean = video ?: false
        fun voteAverage(): Double = voteAverage ?: 0.0
        fun voteCount(): Double = voteCount ?: 0.0
    }
}