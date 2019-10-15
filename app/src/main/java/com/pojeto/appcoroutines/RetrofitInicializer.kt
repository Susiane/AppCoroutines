package com.pojeto.appcoroutines

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer {

    private val retrofit =  Retrofit.Builder()
        .baseUrl("http://swapi.co/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun starWarsService() = retrofit.create<StarWarsApi>(StarWarsApi::class.java)

}