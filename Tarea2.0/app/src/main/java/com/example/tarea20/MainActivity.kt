package com.example.tarea20

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.tarea20.databinding.ActivityMainBinding

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

        binding.buttonadd.setOnClickListener{
            replaceFragment(FormsFragment())
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
                replaceFragment(SettingsFragment())
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