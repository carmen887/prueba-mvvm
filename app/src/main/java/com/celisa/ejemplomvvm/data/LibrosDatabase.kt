package com.celisa.ejemplomvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.celisa.ejemplomvvm.data.dao.LibrosDao
import com.celisa.ejemplomvvm.data.entity.DatosLibro

@Database(version = 1, entities = [DatosLibro::class])
abstract class LibrosDatabase : RoomDatabase() {

    abstract fun librosDao(): LibrosDao

    companion object {
        @Volatile
        private var INSTANCE: LibrosDatabase? = null

        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                context,
                LibrosDatabase::class.java,
                "libros_db"
            ).build()
            INSTANCE = instance
            instance
        }

    }
}