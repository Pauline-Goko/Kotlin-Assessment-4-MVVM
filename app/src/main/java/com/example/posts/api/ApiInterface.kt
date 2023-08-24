package com.example.posts.api

import com.example.posts.model.Post
import com.example.posts.model.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("/post")
    suspend fun getPosts(): Response<PostsResponse>

    @GET("/post/{id}")
    suspend fun getPostsById(@Path("id") postId: Int): Response<Post>

}