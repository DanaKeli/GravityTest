package com.example.gravitytest.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gravitytest.databinding.FragmentWriteBinding
import com.example.gravitytest.view.adapters.WriteAdapter

class WriteFragment : Fragment() {

    private var _binding: FragmentWriteBinding? = null
    private val binding: FragmentWriteBinding
        get() = _binding ?: throw Exception("Binding error")

    private val onItemClick : (item: LinearLayout) -> Unit = {

    }
    private val adapter = WriteAdapter(onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSectionsList.adapter = adapter
        binding.rvSectionsList.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}