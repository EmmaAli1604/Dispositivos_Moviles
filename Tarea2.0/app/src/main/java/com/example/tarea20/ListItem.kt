package com.example.tarea20

data class ListItem(
    val title: String? = null,            // Para el título del libro
    val author: String? = null,           // Para el autor
    val startDate: String? = null,        // Para la fecha de inicio (Datestart)
    val endDate: String? = null,          // Para la fecha de fin (Datefinal)
    val rating: Double? = null,             // Para la calificación (ratingBaradd)
    val image: ByteArray? = null                //Para la imagen
): java.io.Serializable