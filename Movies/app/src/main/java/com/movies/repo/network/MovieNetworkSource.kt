package com.movies.repo.network

class MovieNetworkSource(private val service: MovieService) {

    suspend fun getNowPlaying(): RemoteMovie {
        return service.getNowPlaying()
    }
}