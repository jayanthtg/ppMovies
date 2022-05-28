package com.movies.repo.network

import retrofit2.http.GET

interface MovieService {

    @GET("https://api.themoviedb.org/3/movie/now_playing?api_key=38a73d59546aa378980a88b645f487fc&language=en-US&page=1")
    suspend fun getNowPlaying(): RemoteMovie
}