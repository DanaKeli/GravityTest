package com.example.gravitytest.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DiffUtil
import com.example.gravitytest.data.Question
import com.example.gravitytest.databinding.AnswersItemBinding

class AnswersAdapter(
    private val onItemClick: (items: FrameLayout) -> Unit
) : androidx.recyclerview.widget.ListAdapter<Question, AnswersVIewHolder>(itemComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswersVIewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AnswersItemBinding.inflate(layoutInflater)
        return AnswersVIewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: AnswersVIewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val itemComparator = object : DiffUtil.ItemCallback<Question>() {
            override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}