package com.example.posts.model

data class PostsResponse(
    var posts : List<Post>,
    var total : Int,
    var limit: Int,
    var skip: Int
)
