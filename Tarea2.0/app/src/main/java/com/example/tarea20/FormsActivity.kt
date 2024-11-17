package com.example.tarea20

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FormsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_forms) // Asocia el diseño con la actividad

        //Variables para guardar el texto

        //Para los botones
        val buttonCancel: Button = findViewById(R.id.cancel_button)
        val buttonSubmit:FloatingActionButton = findViewById(R.id.buttonadd)

        buttonSubmit.setOnClickListener{
            Toast.makeText(this, "Agregar", Toast.LENGTH_SHORT).show()
        }

        buttonCancel.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}