package com.zallpy.listfilter.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.zallpy.listfilter.databinding.FragmentListBinding
import com.zallpy.listfilter.model.Categories
import com.zallpy.listfilter.resources.DBResourceMock
import com.zallpy.listfilter.view.adapter.ListCategoryAdapter

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding
    private lateinit var listAdapter: ListCategoryAdapter
    private var listItems = DBResourceMock.getCategories()

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
        setAdapter(listItems)
        editorAction()
    }

    private fun setAdapter(list: List<Categories>) {
        listAdapter = ListCategoryAdapter(
            list
        )

        binding!!.recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun editorAction() {
        binding?.searchEditText?.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filtered = listItems.filter {
                    it.title.contains(s.toString())
                }
                setAdapter(filtered)
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
}