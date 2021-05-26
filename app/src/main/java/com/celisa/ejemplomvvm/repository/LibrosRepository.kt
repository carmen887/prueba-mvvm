package com.celisa.ejemplomvvm.repository

import com.celisa.ejemplomvvm.data.dao.LibrosDao
import com.celisa.ejemplomvvm.data.entity.DatosLibro

class LibrosRepository( private val libroDao: LibrosDao) {
    suspend fun insertarOrReplace(libro: DatosLibro) = libroDao.insertOrUpdate(libro)
    fun verTodos() = libroDao.verTodos()
    suspend fun eliminar(libro: DatosLibro) = libroDao.eliminar(libro)
    suspend fun buscar(query: String) = libroDao.buscar(query)

}