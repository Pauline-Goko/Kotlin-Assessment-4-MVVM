package com.example.posts.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.posts.databinding.PostListBinding
import com.example.posts.model.Post

class PostRvAdapter (var posts: List<Post>):RecyclerView.Adapter<PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostListBinding.inflate(LayoutInflater.from(parent.context))
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var myPosts = posts[position]

        holder.binding.apply {
            tvTitle2.text = myPosts.title
            tvBody.text = myPosts.body

        }



    }





}



class PostViewHolder(var binding: PostListBinding): RecyclerView.ViewHolder(binding.root)
