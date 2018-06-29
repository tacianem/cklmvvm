package com.example.tacianemartimiano.cklmvvm.utils.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.utils.listeners.ArticleListener
import com.example.tacianemartimiano.cklmvvm.utils.viewholders.ArticleViewHolder

class ArticleAdapter(val context: Context, val listener: ArticleListener): RecyclerView.Adapter<ArticleViewHolder>() {

    var articlesList = mutableListOf<Article>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articlesList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.article_list_item, parent, false)
        return ArticleViewHolder(view, context, listener)
    }

    override fun getItemCount(): Int {
        return articlesList.count()
    }

}