package com.example.design2

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.design2.databinding.ActivityAddScreenBinding
import java.text.SimpleDateFormat
import java.util.Locale

class AddScreen : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var binding: ActivityAddScreenBinding
    private val calender = Calendar.getInstance()
    private lateinit var sharedPreferences : SharedPreferences
    var fruits = arrayOf(
        "apple",
        "banana",
        "mango",
        "pineapple",
        "watermelon",
        "strawberry",
        "berry"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        binding.backbtn.setOnClickListener {
            val intent = Intent(this@AddScreen,MainActivity::class.java)
            startActivity(intent)
        }
        sharedPreferences = getSharedPreferences("AddScreenPrefs", Context.MODE_PRIVATE)

        binding.calendarView.setOnClickListener {
            showDatePicker()
        }

        val spin = binding.fruitSpinner
        spin.onItemClickListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, fruits
        )
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = ad

    }

    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this, { DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                binding.tvDate.text = "Selected Date: $formattedDate"
            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(
            applicationContext, fruits[p2], Toast.LENGTH_LONG
        ).show()

        with(sharedPreferences.edit()) {
            putString("selected_fruit", fruits.toString())
            apply()
        }
    }
}
