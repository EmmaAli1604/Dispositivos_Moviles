package com.example.tarea20

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FormsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_forms) // Asocia el diseño con la actividad

        //Variables para guardar el texto

        //Para los botones
        val buttonCancel: Button = findViewById(R.id.cancel_button)
        val buttonSubmit:FloatingActionButton = findViewById(R.id.buttonadd)

        val items = arrayOf("Planeta", "Porrua", "Gandhi", "Penguin Random House","Urano","Oceano")
        val textField = findViewById<TextInputLayout>(R.id.InputEditorialtext)
        (textField.editText as? MaterialAutoCompleteTextView)?.setSimpleItems(items)

        // Referencia al EditText de la fecha de inicio
        val dateStartEditText = findViewById<EditText>(R.id.Datestart)

        //Referencia al EditText de la fecha de final
        val dateFinalEditText = findViewById<EditText>(R.id.Datefinal)

        // Configurar DatePickerDialog
        val calendar = Calendar.getInstance()

        val datePickerStart = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                // Formatear y mostrar la fecha seleccionada
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dateStartEditText.setText(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        val datePickerFinal = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                // Formatear y mostrar la fecha seleccionada
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dateFinalEditText.setText(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Mostrar el DateStartPicker al tocar el campo
        dateStartEditText.setOnClickListener {
            datePickerStart.show()
        }

        // Mostrar el DateStartPicker al tocar el campo
        dateFinalEditText.setOnClickListener {
            datePickerFinal.show()
        }

        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)

        // Escuchar selección de un chip
        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            for (checkedId in checkedIds) {
                val selectedChip = findViewById<Chip>(checkedId)
                Toast.makeText(this, "Seleccionaste: ${selectedChip?.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // Agregar dinámicamente un chip
        val newChip = Chip(this).apply {
            text = "Opción 3"
            isClickable = true
            isCheckable = true
        }
        chipGroup.addView(newChip)

        // Eliminar un chip dinámicamente
        newChip.setOnClickListener {
            chipGroup.removeView(newChip)
            Toast.makeText(this, "Chip eliminado", Toast.LENGTH_SHORT).show()
        }

        buttonSubmit.setOnClickListener{
            
        }

        buttonCancel.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}