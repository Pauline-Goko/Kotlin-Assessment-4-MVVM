package com.example.posts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.posts.R
import com.example.posts.databinding.ActivityMainBinding
import com.example.posts.model.Post
import com.example.posts.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    val postViewModel: PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    var posts: List<Post> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()

        postViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })

        postViewModel.postsLiveData.observe(this, Observer { posts ->
            val adapter = PostRvAdapter(posts?: emptyList())
            binding.rvPosts.adapter = adapter

        })
    }
}