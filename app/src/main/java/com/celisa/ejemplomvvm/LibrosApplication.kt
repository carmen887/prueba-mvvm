package com.celisa.ejemplomvvm

import android.app.Application
import com.celisa.ejemplomvvm.data.LibrosDatabase
import com.celisa.ejemplomvvm.repository.LibrosRepository

class LibrosApplication: Application() {
    private val database by lazy{
        LibrosDatabase.getDatabase(this)
    }
    val libRepository by lazy{
        val libDao = database.librosDao()
        LibrosRepository(libDao)
    }
}