package com.celisa.ejemplomvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.celisa.ejemplomvvm.data.entity.DatosLibro
import com.celisa.ejemplomvvm.repository.LibrosRepository
import kotlinx.coroutines.launch

class DatosLibroViewModel(private val librosRepository: LibrosRepository): ViewModel() {

    val nombreInput = MutableLiveData("")
    val isbnInput = MutableLiveData("")
    val autorInput = MutableLiveData("")
    val editorialInput = MutableLiveData("")
    val anioInput = MutableLiveData("")

    val libList = librosRepository.verTodos()

    private val _verTexto = MutableLiveData("")
    val verTexto: LiveData<String> get() = _verTexto

    fun onSubmit() {
        viewModelScope.launch {
            if(!isbnInput.value.isNullOrEmpty() && nombreInput.value.isNullOrEmpty() && autorInput.value.isNullOrEmpty()
                && editorialInput.value.isNullOrEmpty() && anioInput.value.isNullOrEmpty()){
                val newBook = DatosLibro(isbnInput.value!!, nombreInput.value!!,
                    autorInput.value!!, editorialInput.value!!, anioInput.value!!)
                librosRepository.insertarOrReplace(newBook)
                isbnInput.value = ""
                nombreInput.value = ""
                autorInput.value = ""
                editorialInput.value = ""
                anioInput.value = ""
            }

        }
    }

    fun actualizarVerTexto(libs: List<DatosLibro>) {
        var newtext = ""
        libs.forEach {
        newtext += """
                Nombre: ${it.nombre}
                \t\ISBN: ${it.isbn} 
                \t\Autor: ${it.autor} 
                \t\Editorial: ${it.editorial}
                 \t\Año: ${it.anio} 
            """.trimIndent()
        }

        _verTexto.value = newtext
    }
}