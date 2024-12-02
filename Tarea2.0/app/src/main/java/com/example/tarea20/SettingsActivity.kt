package com.example.tarea20

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_settings)

        val buttonback : Button = findViewById(R.id.back_Button)

        buttonback.setOnClickListener {
            Log.d("SettingsActivity", "Button clicked")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}