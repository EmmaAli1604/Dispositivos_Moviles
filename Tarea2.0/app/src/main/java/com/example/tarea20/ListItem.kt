package com.example.tarea20

data class ListItem(
    val title: String,            // Para el título del libro
    val author: String,           // Para el autor
    val editorial: String,        // Para la editorial
    val startDate: String,        // Para la fecha de inicio (Datestart)
    val endDate: String,          // Para la fecha de fin (Datefinal)
    val opinion: String,          // Para la opinión sobre el libro
    val categories: List<String>, // Para las categorías seleccionadas
    val rating: Float             // Para la calificación (ratingBaradd)
)