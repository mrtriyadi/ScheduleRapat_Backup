package com.renditriyadi.schedulerapat

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class DatabaseHelper(private val context: Context) {

    private val databaseRapat: DatabaseRapat by lazy {
        DatabaseRapat.getInstance(context)
    }

    private val rapatDao: RapatDAO by lazy {
        databaseRapat.rapatDao()
    }

    suspend fun getRapat(): List<Rapat> = withContext(Dispatchers.IO) {
        rapatDao.getAllRapat()
    }

    suspend fun addRapat(rapat: Rapat) = withContext(Dispatchers.IO) {
        rapatDao.addRapat(rapat)
    }

}