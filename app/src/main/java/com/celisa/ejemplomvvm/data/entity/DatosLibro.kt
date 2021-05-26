package com.celisa.ejemplomvvm.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros_table")
data class DatosLibro(
    @PrimaryKey var isbn: String,
    var nombre: String,
    var autor: String,
    var editorial: String,
    var anio: String
)