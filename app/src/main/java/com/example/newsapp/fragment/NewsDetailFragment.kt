package com.example.newsapp.fragment

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.newsapp.NewsModel
import com.example.newsapp.R
import com.example.newsapp.models.Categories

class NewsDetailFragment : Fragment() {

    private lateinit var news: NewsModel

    private lateinit var newsTitleTV: TextView
    private lateinit var newsDescriptionTV: TextView
    private lateinit var newsIV: ImageView
    private lateinit var newsContainer: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        news = arguments?.getSerializable("news") as NewsModel
        val view = inflater.inflate(R.layout.fragment_news_detail, container, false)

        newsTitleTV = view.findViewById(R.id.news_detail_title)
        newsDescriptionTV = view.findViewById(R.id.news_detail_description)
        newsIV = view.findViewById(R.id.news_detail_image)
        newsContainer = view.findViewById(R.id.news_detail_container)

        newsTitleTV.text = news.name
        newsDescriptionTV.text = news.description

        Glide.with(requireContext()).load(news.url).into(newsIV)

        when(news.category){
            Categories.Politics -> newsContainer.background = ColorDrawable(ContextCompat.getColor(requireContext(), R.color.black))
            Categories.Finance -> newsContainer.background = ColorDrawable(ContextCompat.getColor(requireContext(), R.color.red))
            Categories.Education -> newsContainer.background = ColorDrawable(ContextCompat.getColor(requireContext(), R.color.blue))
            Categories.Health -> newsContainer.background = ColorDrawable(ContextCompat.getColor(requireContext(), R.color.orange))
        }

        return view
    }

}