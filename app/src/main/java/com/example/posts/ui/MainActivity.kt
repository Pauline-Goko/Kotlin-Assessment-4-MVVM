package com.example.posts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.posts.R
import com.example.posts.databinding.ActivityMainBinding
import com.example.posts.model.Post
import com.example.posts.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    val postViewModel: PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()

        postViewModel.postsLiveData.observe(this) { postList ->
            var postAdapter = PostRvAdapter(postList ?: emptyList())
            binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvPosts.adapter = postAdapter
            Toast.makeText(baseContext, "fetched successfully", Toast.LENGTH_LONG).show()
        }


        postViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        })

    }
}