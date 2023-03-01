package com.zallpy.listfilter.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zallpy.listfilter.databinding.FragmentListBinding
import com.zallpy.listfilter.model.Categories
import com.zallpy.listfilter.resources.DBResourceMock
import com.zallpy.listfilter.view.ListFragment
import com.zallpy.listfilter.view.adapter.ListCategoryAdapter

class ListViewModel (
    private val binding: FragmentListBinding,
    private val fragment: ListFragment) : ViewModel() {

    private lateinit var listAdapter: ListCategoryAdapter
    private var listItems = DBResourceMock.getCategories()

    fun populateList() {
        setAdapter(listItems)
    }

    private fun setAdapter(list: List<Categories>) {
        listAdapter = ListCategoryAdapter(
            list
        )

        binding.recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(fragment.context)
        }
    }

    fun filterItems(charS: CharSequence) {
        val filtered = listItems.filter {
            it.title.contains(charS.toString())
        }
        setAdapter(filtered)
    }

    class ListViewModelProvider (
        private val binding: FragmentListBinding,
        private val fragment: ListFragment
        ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ListViewModel(binding, fragment) as T
        }
    }
}