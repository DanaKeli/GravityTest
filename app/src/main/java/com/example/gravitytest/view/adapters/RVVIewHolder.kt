package com.example.gravitytest.view.adapters

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.gravitytest.data.Question
import com.example.gravitytest.databinding.AnswersItemBinding

class RVVIewHolder(
    private val binding: AnswersItemBinding,
    private val onItemClick: (item: FrameLayout) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(question: Question) {
        binding.tvQuestion1.text = question.title

        binding.shortCard.setOnClickListener {
            onItemClick(binding.shortCard)
            binding.shortCard.visibility = GONE
            binding.longCard.visibility = VISIBLE
            binding.tvQuestion2.text = question.title
            binding.tvAnswers.text = question.reply
        }
        binding.longCard.setOnClickListener {
            onItemClick(binding.longCard)
            binding.shortCard.visibility = VISIBLE
            binding.longCard.visibility = GONE
        }

    }

}