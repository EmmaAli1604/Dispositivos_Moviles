package com.example.tarea20


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    // Instancia del ViewModel
    private val viewModel: ViewModel by viewModels()

    // Instancia del adaptador
    private lateinit var adapter: ListAdapater

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val library = ArrayList<ListItem>()
        val recyclerView = view.findViewById<RecyclerView>(R.id.list_item)

        // Recupera el objeto pasado como "elemento"
        //viewModel.data.observe(viewLifecycleOwner)
        //{ book ->
        //     = book
        //}

        //book= ListItem("eres ","ramirs","07/07/2021","07/07/2024",4.5)

        viewModel.data.observe(viewLifecycleOwner) { book ->
            // Verifica si el libro es no nulo y agrégalo a la lista
            book?.let {
                library.add(it)
                // Actualiza el adaptador con la nueva lista
                adapter.notifyDataSetChanged() // Asegúrate de que ListAdapter tenga este metodo
            }
        }

        adapter = ListAdapater(library) // Inicializa con una lista vacía
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)


        //viewModel.items.observe(viewLifecycleOwner) { items ->
            // Actualizar el adaptador cuando cambien los datos
            //adapter.updateList(items)
        //}
    }

}
