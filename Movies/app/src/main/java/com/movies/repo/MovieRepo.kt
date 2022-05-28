package com.movies.repo

import com.movies.repo.model.Movie
import com.movies.repo.model.MovieMapper
import com.movies.repo.network.MovieNetworkSource
import com.movies.repo.network.RemoteMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MovieRepo(private val networkSource: MovieNetworkSource) {

    suspend fun getNowPlayingSync(): List<Movie> {
        return convert(networkSource.getNowPlaying())
    }

    fun getNowPlaying(): Flow<List<Movie>> {
        return flow { emit(getNowPlayingSync()) }
    }

    private fun convert(remoteMovie: RemoteMovie): List<Movie> {
        val movies = mutableListOf<Movie>()
        remoteMovie.results().forEach { movies.add(MovieMapper.networkMapper.map(it)) }
        return movies
    }
}