package com.example.newsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Category
import com.example.newsapp.R
import com.example.newsapp.adapters.NewsAdapter


class NewsFragment : Fragment() {
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var currentCategory: Category

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        newsRecyclerView = view.findViewById(R.id.news_recyclerview)
        currentCategory = arguments?.getSerializable("category") as Category

        val newsAdapter = NewsAdapter(currentCategory.news, requireActivity())
        newsRecyclerView.adapter = newsAdapter
        return view
    }


}