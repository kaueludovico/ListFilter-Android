package com.zallpy.listfilter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zallpy.listfilter.databinding.FragmentListBinding
import com.zallpy.listfilter.resources.DBResourceMock
import com.zallpy.listfilter.view.adapter.ListCategoryAdapter

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding
    private lateinit var listAdapter: ListCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    fun setAdapter() {
        listAdapter = ListCategoryAdapter(
            DBResourceMock.getCategories()
        )

        binding!!.recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}