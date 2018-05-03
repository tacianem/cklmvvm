package com.example.tacianemartimiano.cklmvvm.utils.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.model.entities.Article

class ArticleAdapter(val context: Context, val categories: List<Article>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val articleView: View
        val holder: ArticleViewHolder

        if (convertView == null) {
            articleView = LayoutInflater.from(context).inflate(R.layout.article_list_item, null)
            holder = ArticleViewHolder()
            holder.articleTitle = articleView.title
            holder.articleAuthor = articleView.author
            holder.articleDate = articleView.date
            holder.articleImageUrl = articleView.image_url
            //TODO CARREGAR IMAGEM COM GLIDE E RETORNAR, N?!
            articleView.tag = holder
        } else {
            holder = convertView.tag as ArticleViewHolder
            articleView = convertView
        }

        val article = articles[position]
        holder.articleTitle = article.title
        holder.articleAuthor = article.author
        holder.articleDate = article.date
        holder.articleImageUrl = article.image_url
        //TODO CARREGAR IMAGEM COM GLIDE
        return articleView
    }

    override fun getItem(position: Int): Any {
        return articles[position]
    }

    override fun getItemId(position: Int): Long {
        return articles[position].id
    }

    override fun getCount(): Int {
        return articles.count()
    }

}