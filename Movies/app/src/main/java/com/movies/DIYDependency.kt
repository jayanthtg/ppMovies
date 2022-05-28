package com.movies

import com.movies.cloud.MoviesRemote
import com.movies.repo.MovieRepo
import com.movies.repo.network.MovieNetworkSource
import com.movies.repo.network.MovieService

object DIYDependency {

    fun getMovieRepo(): MovieRepo {
        return MovieRepo(getMovieNetworkSource())
    }

    fun getMovieNetworkSource(): MovieNetworkSource {
        return MovieNetworkSource(MoviesRemote.get().client().create(MovieService::class.java))
    }

    fun getMovieService(): MovieService {
        return MoviesRemote.get().client().create(MovieService::class.java)
    }
}