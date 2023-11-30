package com.example.posts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.model.Post
import com.example.posts.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    val postsRepo = PostRepository()
    val postsLiveData = MutableLiveData<List<Post>>()
    val errLiveData = MutableLiveData<String>()


    fun fetchPosts() {
        viewModelScope.launch {
            val response = postsRepo.getPosts()
            if (response.isSuccessful){
                postsLiveData.postValue(response.body())
            }   else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }


    }
}