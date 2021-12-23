package com.example.gravitytest.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gravitytest.R
import com.example.gravitytest.data.Question
import com.example.gravitytest.databinding.FragmentAnswersBinding
import com.example.gravitytest.view.adapters.RVAdapter

class AnswersFragment : Fragment() {
    private var _binding: FragmentAnswersBinding? = null
    private val binding: FragmentAnswersBinding
        get() = _binding ?: throw Exception("Binding error")

    private val onItemClick: (item: FrameLayout) -> Unit = {

    }
    private val adapter = RVAdapter(onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnswersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var newsList: ArrayList<Question> = arrayListOf()
        newsList.add((Question(0, "Вопрос 1", "Какой-то ответ на вопрос")))
        newsList.add((Question(1, "Вопрос 2", "Какой-то ответ на вопрос")))
        newsList.add((Question(2, "Вопрос 3", "Какой-то ответ на вопрос")))
        newsList.add((Question(3, "Вопрос 4", "Какой-то ответ на вопрос")))
        newsList.add((Question(4, "Вопрос 5", "Какой-то ответ на вопрос")))
        newsList.add((Question(5, "Вопрос 6", "Какой-то ответ на вопрос")))

        binding.questionsList.adapter = adapter
        binding.questionsList.layoutManager = LinearLayoutManager(context)
        val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this.requireContext(), R.drawable.item_separator)
            ?.let { divider.setDrawable(it) }
        binding.questionsList.addItemDecoration(divider)
        adapter.submitList(newsList.toList())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}