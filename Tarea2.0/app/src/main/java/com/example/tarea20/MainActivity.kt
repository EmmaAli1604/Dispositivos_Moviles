package com.example.tarea20

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea20.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mylibrary -> replaceFragment(LibraryFragment())
                R.id.pending -> replaceFragment(PendingBooksFragment())
                R.id.todayreading -> replaceFragment(HomeFragment())
                R.id.usuario -> replaceFragment(UserFragment())
                else -> {}
            }
            true
        }

        binding.buttonadd.setOnClickListener {
            val intent = Intent(this, FormsActivity::class.java)
            startActivity(intent)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbarfavorites -> {
                replaceFragment(FavouritesFragment())
                true
            }
            R.id.toolbarsettings-> {
                val intent2 = Intent(this, SettingsActivity::class.java)
                startActivity(intent2)
                true
            }
            R.id.toolbarsearch -> {
                Toast.makeText(this, "Presionaste para buscar", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}