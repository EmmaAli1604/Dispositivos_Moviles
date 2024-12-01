package com.example.tarea20

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
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

    //Boton de imagen
    lateinit var btnImage : Button
    //Datos para mostrar en el recycleview
    private lateinit var tituloTextView: TextView
    private lateinit var autorTextView: TextView
    private lateinit var startDateTextView: TextView
    private lateinit var endDateTextView: TextView
    private lateinit var ratingRatingBar: RatingBar
    //ViewModel
    private val viewModel: ViewModel by viewModels()

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
            }
        }

        // Agregar dinámicamente un chip
        val chipRomance = Chip(this).apply {
            text = "Romance"
            isClickable = true
            isCheckable = true
        }

        val chipThriller = Chip(this).apply {
            text = "Thriller"
            isClickable = true
            isCheckable = true
        }

        val chipTerror = Chip(this).apply {
            text = "Terror"
            isClickable = true
            isCheckable = true
        }

        val chipFantasia = Chip(this).apply {
            text = "Fantasía"
            isClickable = true
            isCheckable = true
        }

        val chipNovela = Chip(this).apply {
            text = "Novela"
            isClickable = true
            isCheckable = true
        }

        val chipHistorico = Chip(this).apply {
            text = "Historia"
            isClickable = true
            isCheckable = true
        }

        val chipAventura = Chip(this).apply {
            text = "Aventura"
            isClickable = true
            isCheckable = true
        }

        val chipPolitica = Chip(this).apply {
            text = "Política"
            isClickable = true
            isCheckable = true
        }

        val chipPoesia = Chip(this).apply {
            text = "Poesía"
            isClickable = true
            isCheckable = true
        }

        val chipMisterio = Chip(this).apply {
            text = "Misterio"
            isClickable = true
            isCheckable = true
        }

        val chipCienciaFiccion = Chip(this).apply {
            text = "Ciencia Ficción"
            isClickable = true
            isCheckable = true
        }

        val chipAutoBio = Chip(this).apply {
            text = "Autobiografía"
            isClickable = true
            isCheckable = true
        }

        val chipBio = Chip(this).apply {
            text = "Biografía"
            isClickable = true
            isCheckable = true
        }

        val chipClasic = Chip(this).apply {
            text = "Clásicos"
            isClickable = true
            isCheckable = true
        }

        val chipGotico = Chip(this).apply {
            text = "Gótico"
            isClickable = true
            isCheckable = true
        }

        val chipCiencia = Chip(this).apply {
            text = "Gótico"
            isClickable = true
            isCheckable = true
        }


        chipGroup.addView(chipGotico)
        chipGroup.addView(chipClasic)
        chipGroup.addView(chipRomance)
        chipGroup.addView(chipCienciaFiccion)
        chipGroup.addView(chipAventura)
        chipGroup.addView(chipAutoBio)
        chipGroup.addView(chipBio)
        chipGroup.addView(chipMisterio)
        chipGroup.addView(chipPoesia)
        chipGroup.addView(chipPolitica)
        chipGroup.addView(chipHistorico)
        chipGroup.addView(chipTerror)
        chipGroup.addView(chipThriller)
        chipGroup.addView(chipFantasia)
        chipGroup.addView(chipNovela)
        chipGroup.addView(chipCiencia)

        val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri ->
            if(uri != null){
                Log.i("aris","seleccionado")
            }else{
                Log.i("aris","no seleccionado")
            }
        }

        btnImage = findViewById(R.id.addimage_button)

        btnImage.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        buttonSubmit.setOnClickListener{
            val titulo = tituloTextView.text.toString()
            val autor = autorTextView.text.toString()
            val startDate = startDateTextView.text.toString()
            val endDate = endDateTextView.text.toString()
            val rating = ratingRatingBar.rating.toDouble()

            val elemento = ListItem(titulo,autor,startDate,endDate,rating)
            viewModel.setData(elemento)

            val intent = Intent(this, HomeFragment::class.java)
            Toast.makeText(this, "Se cambio de pantalla",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }

        buttonCancel.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}