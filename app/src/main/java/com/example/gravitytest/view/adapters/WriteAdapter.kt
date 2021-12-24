package com.example.gravitytest.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.gravitytest.databinding.WriteSectionItemBinding

class WriteAdapter(
    private val onItemClick: (item: LinearLayout) -> Unit
) : RecyclerView.Adapter<WriteViewHolder>() {
    private val itemCount: Int = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = WriteSectionItemBinding.inflate(layoutInflater)
        return WriteViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: WriteViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return itemCount
    }
}