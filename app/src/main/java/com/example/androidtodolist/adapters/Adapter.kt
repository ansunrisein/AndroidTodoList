package com.example.androidtodolist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtodolist.R
import com.google.android.material.card.MaterialCardView

class Adapter(private val values: List<String>): RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = values[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        init {
            val card: MaterialCardView = itemView.findViewById(R.id.card)
            textView = card.findViewById(R.id.text)
        }
    }
}