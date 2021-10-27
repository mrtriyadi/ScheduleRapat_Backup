package com.renditriyadi.schedulerapat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renditriyadi.schedulerapat.databinding.MainActivityBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityBinding

    private val rapatAdapter: RecycleViewAdapter by lazy {
        RecycleViewAdapter()
    }
    private lateinit var rapatBaru:Rapat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        showFormTambah()

        showListRapat()
    }

    private fun showListRapat() {
        binding.rvListRapat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        binding.rvListRapat.adapter= rapatAdapter
        val databaseHelper = DatabaseHelper(this)

        MainScope().launch {
            val listRapat = databaseHelper.getRapat()
            runOnUiThread {
               rapatAdapter.addDaftarRapat(listRapat)
            }
        }
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