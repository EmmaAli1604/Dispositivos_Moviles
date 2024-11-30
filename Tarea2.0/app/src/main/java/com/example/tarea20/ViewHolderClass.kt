package com.example.tarea20

import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputLayout

class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {

    val title = view.findViewById<TextInputLayout>(R.id.inputtitle)
    val author = view.findViewById<TextInputLayout>(R.id.inputauthor)
    val editorial = view.findViewById<AutoCompleteTextView>(R.id.Editorial)
    val startDate = view.findViewById<TextInputLayout>(R.id.Datestart)
    val endDate = view.findViewById<TextInputLayout>(R.id.Datefinal)
    val opinion = view.findViewById<TextInputLayout>(R.id.editopinion)
    val rating = view.findViewById<RatingBar>(R.id.ratingBaradd)
    val categories = view.findViewById<ChipGroup>(R.id.chipGroup)

    fun render(listItemModel: ListItem){

    }
}

