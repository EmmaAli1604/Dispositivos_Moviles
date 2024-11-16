package com.example.tarea20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.tarea20.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class FormsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_forms, container, false)

        val defaultNavBar = requireActivity().findViewById<BottomNavigationView>(R.id.navigationmenu)
        val alternativeNavBar = requireActivity().findViewById<BottomNavigationView>(R.id.navigationmenu_forms)

        defaultNavBar.visibility = View.GONE
        alternativeNavBar.visibility = View.VISIBLE

        val button1: Button = view.findViewById(R.id.cancel_button)
        val button2: Button = view.findViewById(R.id.buttonadd)
        button1.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            Toast.makeText(activity, "Agregar", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val defaultNavBar = requireActivity().findViewById<BottomNavigationView>(R.id.navigationmenu)
        val alternativeNavBar = requireActivity().findViewById<BottomNavigationView>(R.id.navigationmenu_forms)

        defaultNavBar.visibility = View.VISIBLE
        alternativeNavBar.visibility = View.GONE
    }

}