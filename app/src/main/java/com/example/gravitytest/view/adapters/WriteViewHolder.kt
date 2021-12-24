package com.example.gravitytest.view.adapters

import android.view.View.INVISIBLE
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gravitytest.R
import com.example.gravitytest.databinding.WriteSectionItemBinding

class WriteViewHolder(
    private val binding: WriteSectionItemBinding,
    private val onItemClick: (item: LinearLayout) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int) {
        when (position) {
            0 -> {
                binding.ivIcon.setImageDrawable(
                    ContextCompat
                        .getDrawable(itemView.context, R.drawable.ic_questionmark_circle_fill)
                )
                binding.tvSectionName.setText(R.string.feedback)
            }
            1 -> {
                binding.ivIcon.setImageDrawable(
                    ContextCompat
                        .getDrawable(itemView.context, R.drawable.ic_phone_fill)
                )
                binding.tvSectionName.setText(R.string.call)
            }
            2 -> {
                binding.ivIcon.setImageDrawable(
                    ContextCompat
                        .getDrawable(itemView.context, R.drawable.ic_person_fill_questionmark)
                )
                binding.tvSectionName.setText(R.string.ask_question)
                binding.sectionDivider.visibility = INVISIBLE
            }
        }
        binding.writeSectionLayout.setOnClickListener {
            onItemClick(binding.writeSectionLayout)
        }

    }
}