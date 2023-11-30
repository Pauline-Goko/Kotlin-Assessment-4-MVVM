package com.example.posts.repository

import com.example.posts.api.ApiClient
import com.example.posts.api.ApiInterface
import com.example.posts.model.Post
import com.example.posts.model.PostsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepository {

    val apiClient = ApiClient.buildClient(ApiInterface::class.java)


    suspend fun getPosts(): Response<List<Post>> {
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}