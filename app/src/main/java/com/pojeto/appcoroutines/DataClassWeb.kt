package com.pojeto.appcoroutines

import com.google.gson.annotations.SerializedName


data class FilmResult(val results : List<Film>)

data class Film(val title: String,
                @SerializedName("episode_id") val epsodeId: Int,
                @SerializedName("characters") val personUrls: List<String>)

data class Person(val name: String, val gender: String)