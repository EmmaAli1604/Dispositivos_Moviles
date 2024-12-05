package com.example.tarea20

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapater(private var books: ArrayList<ListItem>) : RecyclerView.Adapter<ListAdapater.BookViewHolder>() {

    //var onContextMenuClickListener: ((MenuItem, Int) -> Unit)? = null

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
        if (book.image != null) {
            val bitmap = BitmapFactory.decodeByteArray(book.image, 0, book.image.size)
            holder.imageView.setImageBitmap(bitmap)  // Establece la imagen en el ImageView
        }
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
        val ratingRatingBar: RatingBar = itemView.findViewById(R.id.rating_bar_view)
        val imageView:ImageView = itemView.findViewById(R.id.image_view)
        //val buttonOption: Button = itemView.findViewById(R.id.menu_button_item)
    }


}
