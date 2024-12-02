package com.example.tarea20

import android.app.DatePickerDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FormsActivity : AppCompatActivity() {

    //Boton de imagen
    private lateinit var btnImage : Button

    //Datos del registro
    private lateinit var Titulo:TextInputEditText
    private lateinit var Autor: TextInputEditText
    private lateinit var ISBN: TextInputEditText
    private lateinit var Editorial:TextInputLayout
    private lateinit var dateStartEditText:EditText
    private lateinit var dateFinalEditText: EditText
    private lateinit var Opinion: TextInputEditText
    private lateinit var ratingBar: RatingBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_forms) // Asocia el diseño con la actividad

        //Para los botones
        val buttonCancel: Button = findViewById(R.id.cancel_button)
        val buttonSubmit:FloatingActionButton = findViewById(R.id.buttonadd)

        //Para los datos de texto
        Titulo = findViewById(R.id.titulo_text)
        Autor = findViewById(R.id.autor_text)
        ISBN = findViewById(R.id.ISBN_text)
        Opinion = findViewById(R.id.opinion_text)

        //Rating Bar
        ratingBar = findViewById(R.id.ratingBaradd)

        //Datos de la editorial
        val items = arrayOf("Planeta", "Porrua", "Gandhi", "Penguin Random House","Urano","Oceano")
        Editorial = findViewById(R.id.InputEditorialtext)
        (Editorial.editText as? MaterialAutoCompleteTextView)?.setSimpleItems(items)

        // Referencia al EditText de la fecha de inicio
        dateStartEditText = findViewById(R.id.Datestart)

        //Referencia al EditText de la fecha de final
        dateFinalEditText = findViewById(R.id.Datefinal)

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

        buttonCancel.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun limpiarFormulario() {
        ISBN.setText("")
        Titulo.setText("")
        Autor.setText("")
        Editorial.editText?.setText("")
        dateStartEditText.setText("")
        dateFinalEditText.setText("")
        Opinion.setText("")
        ratingBar.rating = 0f
    }

    fun insert(view: View){
        val con = SQLite(this,"Libreria",null,1)
        var bd = con.writableDatabase

        if (bd.isOpen) {
            Log.i("DatabaseCheck", "Base de datos abierta correctamente")
        } else {
            Log.e("DatabaseCheck", "Error al abrir la base de datos")
        }

        var isbn = ISBN.text.toString()
        var titulo = Titulo.text.toString()
        var autor = Autor.text.toString()
        var editorial = Editorial.editText?.text.toString()
        var fechaInicio = dateStartEditText.text.toString()
        var fechaFinal = dateFinalEditText.text.toString()
        var opinion = Opinion.text.toString()
        var rating = ratingBar.rating

        if(
            isbn.isNotEmpty() &&
            titulo.isNotEmpty() &&
            autor.isNotEmpty() &&
            editorial.isNotEmpty() &&
            fechaInicio.isNotEmpty() &&
            fechaFinal.isNotEmpty() &&
            rating != 0f // Verifica que el rating no sea 0
        ){
            val registro = ContentValues()
            registro.put("ISBN", isbn)
            registro.put("Titulo", titulo)
            registro.put("Autor", autor)
            registro.put("Editorial", editorial)
            registro.put("FechaInicio", fechaInicio)
            registro.put("FechaFinal", fechaFinal)
            registro.put("Opinion", opinion)
            registro.put("Rating", rating.toFloat())

            try {
                bd.insert("Libro", null, registro)
                Toast.makeText(this, "Registro agregado exitosamente", Toast.LENGTH_LONG).show()
                limpiarFormulario()
            } catch (e: Exception) {
                Toast.makeText(this, "Error al agregar el registro: ${e.message}", Toast.LENGTH_LONG).show()
            } finally {
                bd.close()
            }

            Toast.makeText(this,"Se agrego exisitosmanete el registro",Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }else{
            Toast.makeText(this,"No se realizo el regiistro",Toast.LENGTH_LONG).show()
        }
    }
}