package com.example.noticiasactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noticiasactivity.databinding

class MainActivity : AppCompatActivity() {
    private lateinit var NoticiasAdapter: NoticiasAdapter
    private lateinit var linearLayout: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        NoticiasAdapter = NoticiasAdapter(mutableListOf())
        var linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            var layoutManager = linearLayoutManager
            var adapter = NoticiasAdapter
        }
}