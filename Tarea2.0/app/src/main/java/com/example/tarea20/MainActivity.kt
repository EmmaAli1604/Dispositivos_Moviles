package com.example.tarea20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }


}