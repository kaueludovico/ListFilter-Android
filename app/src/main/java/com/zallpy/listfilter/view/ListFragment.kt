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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zallpy.listfilter.databinding.FragmentListBinding
import com.zallpy.listfilter.model.Categories
import com.zallpy.listfilter.resources.DBResourceMock
import com.zallpy.listfilter.view.adapter.ListCategoryAdapter
import com.zallpy.listfilter.viewModel.ListViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    val binding get() = _binding

    private lateinit var viewModel: ListViewModel


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

        binding?.let {
            viewModel = ViewModelProvider(
                this,
                ListViewModel.ListViewModelProvider(it, ListFragment())
            )[ListViewModel::class.java]
        }

        viewModel.populateList()
        editorAction()
    }

    private fun editorAction() {
        binding?.searchEditText?.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do Nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let { viewModel.filterItems(it) }
            }

            override fun afterTextChanged(s: Editable?) {
                // Do Nothing
            }
        })
    }
}