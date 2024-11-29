package com.example.tarea20

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapater(private val dataList: ArrayList<ListItem>) : RecyclerView.Adapter<ListAdapater.ViewHolderClass>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAdapater.ViewHolderClass {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListAdapater.ViewHolderClass, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolderClass (itemView: View): RecyclerView.ViewHolder(itemView){
    }

}