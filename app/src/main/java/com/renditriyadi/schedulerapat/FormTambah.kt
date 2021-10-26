package com.renditriyadi.schedulerapat

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.renditriyadi.schedulerapat.databinding.ActivityFormTambahBinding
import java.text.SimpleDateFormat
import java.util.*


class FormTambah : AppCompatActivity() {
    private lateinit var binding: ActivityFormTambahBinding
    private lateinit var meetingDate: Calendar
    private lateinit var meetingTime: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormTambahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.ivShowDatePicker.setOnClickListener {
            showDatePicker()
        }
        binding.ivShowTimePicker.setOnClickListener {
            showTimePicker()
        }
    }

    private fun showTimePicker() {
        TODO() //fungsi untuk menampilkan waktu yang dipilih dari Time Picker ke tv_time_picked
    }

    private fun showDatePicker() {
        meetingDate = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            meetingDate.set(Calendar.YEAR, year)
            meetingDate.set(Calendar.MONTH, monthOfYear)
            meetingDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val dateFormat = "dd-MM-yyyy"
            val sdf = SimpleDateFormat(dateFormat, Locale.US)
            binding.tvDatePicked.text = "Meeting Date: "+sdf.format(meetingDate.time)
        }

        DatePickerDialog(this, dateSetListener,
            meetingDate.get(Calendar.YEAR),
            meetingDate.get(Calendar.MONTH),
            meetingDate.get(Calendar.DAY_OF_MONTH)).show()
    }
}