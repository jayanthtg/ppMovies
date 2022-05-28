package com.movies.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.DIYDependency
import com.movies.repo.MovieRepo
import com.movies.repo.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val repo: MovieRepo = DIYDependency.getMovieRepo()
    private val _nowPlayingMovies: MutableLiveData<List<Movie>> = MutableLiveData()
    val nowPlayingMovies: LiveData<List<Movie>> = _nowPlayingMovies


    fun getNowPlayingMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _nowPlayingMovies.postValue(repo.getNowPlayingSync())
        }
    }
}