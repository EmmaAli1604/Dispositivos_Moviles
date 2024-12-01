package com.example.tarea20

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class ViewModel : ViewModel() {
    private val _data = MutableLiveData<ListItem>()
    val data: LiveData<ListItem> = _data

    fun setData(newData: ListItem)
    {
        _data.value = newData

    }

    //init {
        //_items.value = listOf()
    //}

    // Metodo para agregar un nuevo elemento
    //fun addItem(item: ListItem) {
        //val currentList = _items.value ?: listOf()
        //_items.value = currentList + item // Agregar un nuevo elemento a la lista
    //}

    // Metodo para eliminar un elemento
    //fun removeItem(item: ListItem) {
        //val currentList = _items.value ?: listOf()
        //_items.value = currentList.filter { it != item } // Eliminar el elemento de la lista
    //}

    // Metodo para actualizar la lista completa
    //fun updateItems(newItems: List<ListItem>) {
        //_items.value = newItems
    //}
}
