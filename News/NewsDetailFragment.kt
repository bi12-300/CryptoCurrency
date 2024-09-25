package com.example.cryptocurrency.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.Model.NewsItem
import com.example.cryptocurrency.R

class NewsDetailFragment : Fragment() {

    private lateinit var newsItem: NewsItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsItem = it.getParcelable(ARG_NEWS_ITEM)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_news_detail, container, false)

        val titleTextView: TextView = view.findViewById(R.id.text_title)
        val descriptionTextView: TextView = view.findViewById(R.id.text_description)

        titleTextView.text = newsItem.title
        descriptionTextView.text = newsItem.description

        return view
    }

    companion object {
        private const val ARG_NEWS_ITEM = "news_item"

        fun newInstance(newsItem: NewsItem): NewsDetailFragment {
            val fragment = NewsDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_NEWS_ITEM, newsItem)
            fragment.arguments = args
            return fragment
        }
    }
}
