package com.example.noticiasactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoticiasAdapter (private val noticias: List<Noticias>){

    private lateinit var context: Context
    inner class ViewHolder(view: View):
        RecyclerView.ViewHolder(view) {
        // vinculamos la vista al adaptador
        val binding = ItemNoticiaBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater
                .from(context)
                .inflate(R.layout.item_noticias, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int = users.size

}