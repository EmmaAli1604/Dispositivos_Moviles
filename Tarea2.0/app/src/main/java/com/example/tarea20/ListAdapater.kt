package com.example.tarea20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapater(private var books: ArrayList<ListItem>) : RecyclerView.Adapter<ListAdapater.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.pantalla2, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.titleTextView.text = book.title
        holder.authorTextView.text = book.author
        holder.startDateTextView.text = book.startDate
        holder.endDateTextView.text = book.endDate
        holder.ratingRatingBar.rating = book.rating?.toFloat() ?: 0f
    }

    override fun getItemCount(): Int {
        return books.size
    }

    fun updateList(newList: ArrayList<ListItem>) {
        books = newList
        notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title_view)
        val authorTextView: TextView = itemView.findViewById(R.id.author_view)
        val startDateTextView: TextView = itemView.findViewById(R.id.startdate_view)
        val endDateTextView: TextView = itemView.findViewById(R.id.enddate_view)
        val ratingRatingBar : RatingBar = itemView.findViewById(R.id.rating_bar_view)
    }

}
