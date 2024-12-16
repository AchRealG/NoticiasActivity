package com.example.noticiasactivity

import android.content.Context
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


}