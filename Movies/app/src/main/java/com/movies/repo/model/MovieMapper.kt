package com.movies.repo.model

import com.movies.Constants
import com.movies.repo.network.RemoteMovie
import com.swish.game.data.mappers.BasicMapper
import com.swish.game.data.mappers.Mapper

/**
 * @author Jayanth Tg
 *
 * Movie mapper will contain all the mappers which required expose the model.
 * networkMapper: will convert remote entity to model
 * [Not implemented]localMapper: will convert room entity to model
 * [Not implemented] dbMapper: will convert remote entity to room enity.
 */

object MovieMapper {

    val networkMapper: Mapper<RemoteMovie.Result, Movie> = NetworkMapper()

    private class NetworkMapper : BasicMapper<RemoteMovie.Result, Movie>() {
        override fun map(item: RemoteMovie.Result): Movie {
            return with(item) {
                Movie(
                    id(), Constants.Url.IMAGE_BASE_URL + backDropPath(), genreIds(), title(),
                    Constants.Url.IMAGE_BASE_URL + posterPath(), adult(), originalLanguage(), originalTitle(),
                    overview(), popularity(), releaseDate(), video(), voteAverage(), voteCount()
                )
            }
        }
    }
}

