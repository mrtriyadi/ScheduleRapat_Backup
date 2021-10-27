package com.renditriyadi.schedulerapat


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RapatDAO{
    @Query("SELECT * FROM RAPAT")
    fun getAllRapat(): List<Rapat>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRapat(rapat: Rapat)
}
