package com.example.posts.api

import com.example.posts.model.Post
import com.example.posts.model.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>



}