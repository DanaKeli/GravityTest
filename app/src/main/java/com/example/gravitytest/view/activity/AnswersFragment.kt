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
import com.example.gravitytest.view.adapters.AnswersAdapter

class AnswersFragment : Fragment() {
    private var _binding: FragmentAnswersBinding? = null
    private val binding: FragmentAnswersBinding
        get() = _binding ?: throw Exception("Binding error")

    private val onItemClick: (item: FrameLayout) -> Unit = {

    }
    private val adapter = AnswersAdapter(onItemClick)

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
        newsList.add(
            (Question(
                0, "Вопрос 1", "Как правильно сделать FAQ:\n" +
                        "1. Соберите вопросы\n" +
                        "2. Разбейте вопросы на категории\n" +
                        "3. Составьте ответы на вопросы\n" +
                        "4. Подумайте над целевыми действиями\n" +
                        "5. Расположите FAQ на видном месте\n" +
                        "6. Добавьте поиск"
            ))
        )
        newsList.add(
            (Question(
                1, "Вопрос 2", "Ошибки при составлении FAQ:\n" +
                        "1. Добавлять большой раздел FAQ на новый сайт\n" +
                        "2. Придумывать новые названия для страницы FAQ\n" +
                        "3. Заводить раздел FAQ по принципу «чтобы было»\n" +
                        "4. Набивать FAQ нерелевантным контентом\n" +
                        "5. Не отфильтровывать воду из огромных «простыней» текста"
            ))
        )
        newsList.add(
            (Question(
                2,
                "Вопрос 3",
                "Частые ошибки в частых вопросах.\n1.Не актуально — вопросы не отобраны из" +
                        "клиентских, а придуманы директором." +
                        "Люди пробегают страницу глазами и тут же уходят, Яндекс фиксирует на" +
                        "сайте неинтересную страницу.\n" +
                        "2. Много текста — слишком подробные ответы, вопросы, которые не такие уж и" +
                        "частые, а иногда раздел состоит из нескольких страниц (кто по ним лазить" +
                        "будет, если быстрее позвонить???). Сократите, структурируйте или" +
                        "переделайте в полноценный «Вопрос-Ответ»."
            ))
        )
        newsList.add((Question(3, "Вопрос 4", "Какой-то ответ на вопрос")))
        newsList.add((Question(4, "Вопрос 5", "Какой-то ответ на вопрос")))
        newsList.add((Question(5, "Вопрос 6", "Какой-то ответ на вопрос")))

        binding.rvQuestionsList.adapter = adapter
        binding.rvQuestionsList.layoutManager = LinearLayoutManager(context)
        val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(this.requireContext(), R.drawable.item_separator)
            ?.let { divider.setDrawable(it) }
        binding.rvQuestionsList.addItemDecoration(divider)
        adapter.submitList(newsList.toList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}