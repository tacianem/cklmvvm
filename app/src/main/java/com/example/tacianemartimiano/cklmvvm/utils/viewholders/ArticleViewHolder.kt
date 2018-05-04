package com.example.tacianemartimiano.cklmvvm.utils.viewholders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.utils.glide.GlideApp
import kotlinx.android.synthetic.main.article_list_item.view.*

class ArticleViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

    fun bindArticle(article: Article, context: Context) {
        GlideApp.with(context)
                .load(article.imageUrl)
                .into(itemView.image)
        itemView.title.text = article.title
        itemView.author.text = article.author
        itemView.date.text = article.date
    }
}
