package com.example.design2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.design2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        val sharedPreferences = getSharedPreferences("AddScreenPrefs", Context.MODE_PRIVATE)
        val selectedFruits = sharedPreferences.getString("selectedFruit", "No SelectedFruits")
        val selectedDate = sharedPreferences.getString("selected_date", "No date selected")

        binding.icategory.text = "selected Fruit : $selectedFruits"
        binding.idate.text = "selected Date : $selectedDate"
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.edit1.setOnClickListener {
            val intent = Intent(this@MainActivity, AddScreen::class.java)
            startActivity(intent)
        }

        binding.edit2.setOnClickListener {
            val intent = Intent(this@MainActivity, AddScreen::class.java)
            startActivity(intent)
        }

        binding.edit3.setOnClickListener {
            val intent = Intent(this@MainActivity, AddScreen::class.java)
            startActivity(intent)
        }
        binding.edit4.setOnClickListener {
            val intent = Intent(this@MainActivity, AddScreen::class.java)
            startActivity(intent)
        }

        binding.addbtn.setOnClickListener {
            val intent = Intent(this@MainActivity,AddScreen::class.java)
            startActivity(intent)
        }
    }
}