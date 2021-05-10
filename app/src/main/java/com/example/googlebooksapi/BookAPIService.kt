package com.example.googlebooksapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val QUERY_STRING =
    "volumes?q=android=inTitle&maxResults=5"

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(
    moshi)).baseUrl(BASE_URL).build()

interface BookAPIService {
    @GET(QUERY_STRING)
    fun getBooks(): Call<String>
}

object BookAPI{
    val bookApi: BookAPIService by lazy {
        retrofit.create(BookAPIService::class.java)
    }
}