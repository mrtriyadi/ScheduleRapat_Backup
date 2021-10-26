package com.renditriyadi.schedulerapat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.renditriyadi.schedulerapat.databinding.MainActivityBinding
import java.text.Normalizer

class MainActivity : AppCompatActivity() {
    private lateinit var binding : MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFormTambah()
    }

    private fun showFormTambah() {
        binding.ivShowForm.setOnClickListener {
            val intent = Intent(this, FormTambah::class.java)
            startActivity(intent)
        }
        binding.tvShowForm.setOnClickListener {
            val intent = Intent(this, FormTambah::class.java)
            startActivity(intent)
        }
    }
}