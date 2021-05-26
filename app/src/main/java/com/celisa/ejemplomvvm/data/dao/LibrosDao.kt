package com.celisa.ejemplomvvm.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.celisa.ejemplomvvm.data.entity.DatosLibro

@Dao
interface LibrosDao {
    //Insertar
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(libro: DatosLibro)

    @Query("SELECT * FROM libros_table")
    fun verTodos(): LiveData<List<DatosLibro>>

    @Query("SELECT * FROM libros_table WHERE isbn = :isbn")
    suspend fun buscar(isbn: String): LiveData<DatosLibro>

    @Delete
    suspend fun eliminar(libro: DatosLibro)
}