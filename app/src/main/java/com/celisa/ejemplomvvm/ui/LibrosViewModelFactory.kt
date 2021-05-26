package com.celisa.ejemplomvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.celisa.ejemplomvvm.repository.LibrosRepository

class LibrosViewModelFactory(private val librosRepository: LibrosRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DatosLibroViewModel::class.java)) {
            return DatosLibroViewModel(librosRepository) as T
        }
        throw Exception("unknow view model class")
    }
}