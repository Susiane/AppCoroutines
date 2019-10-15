package com.pojeto.appcoroutines

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApi{
    @GET("films")
    fun listMovies() : Call<FilmResult>
}