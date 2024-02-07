package com.example.musicplayer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
//    This code is like telling a secret code
    //    to someone to find books in a library.
    //    "@Headers" is sharing the secret codes.
    //    "X-RapidAPI-Key" and "X-RapidAPI-Host"
    //    are two pieces of the secret code, like
    //    a password and username.
    //    "52345b010cmshd32eff9bdb0cd23p1a0f2ajsnc88359e9b044"
    //    is one part, and "deezerdevs-deezer.p.rapidapi.com"
    //    is the other. When we say "@GET("search"),"
    //    it means we're looking for books in the library about a specific topic.
    //    So, with these secret codes, we can search for
    //    books online at the Deezer library about specific topics.
    @Headers("X-RapidAPI-Key: 52345b010cmshd32eff9bdb0cd23p1a0f2ajsnc88359e9b044" + "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")

//    This line of code is like asking a librarian for specific books.
//    "getData" is the librarian's name. "@Query("q") query: String" tells the librarian what books to find.
//    "Call<List<MyData>>" means the librarian will bring back a list of books called "MyData."
//    So, if you say "getData('Harry Potter'),"
//    the librarian will search for books related to Harry Potter and give you a list of those books.
//    Similarly, in the code, when you call "getData" with a specific query,
//    it will fetch a list of "MyData" items related to that query from somewhere, like the internet.
    fun getData(@Query("q") query: String) : Call<List<MyData>>
}