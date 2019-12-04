package com.example.androidtodolist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtodolist.R
import com.example.androidtodolist.fragments.EditBottomDrawerFragment
import com.google.android.material.card.MaterialCardView

class Adapter(
    private val values: MutableList<String>,
    private val showBottomDrawer: (Int) -> EditBottomDrawerFragment
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = values[position]
        holder.setListeners(View.OnClickListener {
            values.removeAt(position)
            this.notifyDataSetChanged()
        }, View.OnClickListener {
            val fragment = showBottomDrawer(position)
            fragment.onDismissListener = { this.notifyDataSetChanged() }
        })

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        private val card: MaterialCardView = itemView.findViewById(R.id.card)

        init {
            textView = card.findViewById(R.id.text)
        }

        fun setListeners(onDelete: View.OnClickListener, onUpdate: View.OnClickListener) {
            card.findViewById<AppCompatImageButton>(R.id.delete).setOnClickListener(onDelete)
            card.findViewById<AppCompatImageButton>(R.id.edit).setOnClickListener(onUpdate)
        }
    }
}