package com.movies.cloud

import com.movies.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * @author Jayanth Tg
 *
 * Remote class which provides retrofit client for network sources.
 */
internal class MoviesRemote private constructor() {

    private val retrofit: Retrofit

    init {
        retrofit = getDefaultClient()
    }

    fun client() = retrofit

    private fun getDefaultClient(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.Url.BASE_URL)
            .build()
    }

    companion object {
        private val x = MoviesRemote()

        @JvmStatic
        fun get(): MoviesRemote {
            return x
        }
    }

}