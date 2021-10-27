package com.renditriyadi.schedulerapat

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.renditriyadi.schedulerapat.databinding.ListRapatBinding

class RecycleViewAdapter: RecyclerView.Adapter<RecycleViewAdapter.RapatViewHolder>() {
    private val daftarRapat: MutableList<Rapat> = mutableListOf()

    fun addDaftarRapat(daftarRapat: List<Rapat>){
        this.daftarRapat.clear()
        this.daftarRapat.addAll(daftarRapat)
        notifyDataSetChanged()
    }

    inner class RapatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(itemRapat: Rapat) = itemView.run{
            val tvJudul: TextView = findViewById(R.id.tv_judul)
            val tvHari: TextView = findViewById(R.id.tv_hari)
            val tvTanggal: TextView = findViewById(R.id.tv_tanggal)
            val tvWaktu: TextView = findViewById(R.id.tv_waktu)
            val tvLokasi: TextView = findViewById(R.id.tv_lokasi)

            tvJudul.text=itemRapat.judul
            tvHari.text=itemRapat.hari
            tvTanggal.text=itemRapat.tanggal
            tvWaktu.text=itemRapat.waktu
            tvLokasi.text=itemRapat.lokasi
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RapatViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_rapat, parent, false)
        return RapatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RapatViewHolder, position: Int) {
        val rapat = daftarRapat[position]
        holder.bind(rapat)
    }

    override fun getItemCount(): Int {
        return daftarRapat.size
    }
}