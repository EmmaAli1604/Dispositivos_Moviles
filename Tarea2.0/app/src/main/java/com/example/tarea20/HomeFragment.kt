package com.example.tarea20

import android.app.LauncherActivity.ListItem
import android.media.RouteListingPreference
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea20.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar

class HomeFragment : Fragment() {
    private lateinit var toolbar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        //val dataset = listOf(
            //Item()
        //)
        //val customAdapter = ListItem(dataset)

        //val recyclerView: RecyclerView = findViewById(R.id.list_item)
        //recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = customAdapter

        return root
    }
}
