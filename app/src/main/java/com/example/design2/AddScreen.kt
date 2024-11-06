package com.example.design2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.design2.databinding.ActivityAddScreenBinding

class AddScreen : AppCompatActivity() {
    lateinit var binding : ActivityAddScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding = ActivityAddScreenBinding.inflate(layoutInflater)
    }
}