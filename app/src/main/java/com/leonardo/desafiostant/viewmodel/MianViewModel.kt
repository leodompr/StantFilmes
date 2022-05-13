package com.leonardo.desafiostant.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leonardo.desafiostant.model.GenreResponse
import com.leonardo.desafiostant.model.MovieResponse
import com.leonardo.desafiostant.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MianViewModel(private val repository: MainRepository) : ViewModel() {

    val movieList = MutableLiveData<MovieResponse>()
    val genreList = MutableLiveData<GenreResponse>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies(page: Int) {

        val requestt = repository.getAllMovie1(page)
        requestt.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                //Quando houver resposta
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                //Quando houver falha
                errorMessage.postValue(t.message)
            }

        })
    }


        fun getAllGenre(){

            val request5 = repository.getAllGenr2()
            request5.enqueue(object : Callback<GenreResponse>{
                override fun onResponse(call: Call<GenreResponse>, response: Response<GenreResponse>) {
                    genreList.postValue(response.body())
                }

                override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }

            })


        }


    }


