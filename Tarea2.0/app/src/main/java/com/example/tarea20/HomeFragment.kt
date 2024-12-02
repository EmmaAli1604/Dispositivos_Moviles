package com.example.tarea20


import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    // Instancia del adaptador
    private lateinit var adapter: ListAdapater

    //Base de datos
    private lateinit var sqliteHelper: SQLite

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa el SQLiteHelper
        sqliteHelper = SQLite(requireContext(), "Libreria", null, 1)
        val library = ArrayList<ListItem>()
        loadDatabaseData(library)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list_item)

        adapter = ListAdapater(library) // Inicializa con una lista vacía
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }

    private fun loadDatabaseData(library: ArrayList<ListItem>) {
        val cursor = sqliteHelper.readDataList() // Obtiene el cursor desde la base de datos

        if (cursor != null && cursor.moveToFirst()) { // Verifica que el cursor no esté vacío
            do {
                // Obtén los datos de cada columna
                val title = cursor.getString(0) // Primera columna: Titulo
                val author = cursor.getString(1) // Segunda columna: Autor
                val startDate = cursor.getString(2) // Tercera columna: FechaInicio
                val endDate = cursor.getString(3) // Cuarta columna: FechaFinal
                val rating = cursor.getFloat(4) // Quinta columna: Rating

                // Crea un objeto ListItem y agrégalo a la lista
                library.add(ListItem(title, author, startDate, endDate, rating.toDouble()))
            } while (cursor.moveToNext())
        }

        cursor?.close() // Cierra el cursor después de usarlo
    }

}
