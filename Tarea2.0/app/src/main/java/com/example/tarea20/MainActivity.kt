package com.example.tarea20

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import com.example.tarea20.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var formsbutton : FloatingActionButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragmente(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mylibrary -> replaceFragmente(LibraryFragment())
                R.id.pending -> replaceFragmente(PendingBooksFragment())
                R.id.todayreading -> replaceFragmente(HomeFragment())
                else -> {}
            }
            true
        }

        binding.buttonadd.setOnClickListener{
            replaceFragmente(FormsFragment())
        }
    }

    private fun replaceFragmente(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)  // Usamos replace en lugar de setTransition
        fragmentTransaction.commit()  // Confirmamos la transacción
    }

}