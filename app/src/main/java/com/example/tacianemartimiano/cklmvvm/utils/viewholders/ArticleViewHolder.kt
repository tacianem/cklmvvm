package com.example.tacianemartimiano.cklmvvm.utils.viewholders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.utils.glide.GlideApp
import com.example.tacianemartimiano.cklmvvm.utils.listeners.ArticleListener
import kotlinx.android.synthetic.main.article_list_item.view.*

class ArticleViewHolder(itemView: View?, val context: Context, listener: ArticleListener?): RecyclerView.ViewHolder(itemView) {

    init {
        itemView?.setOnClickListener {
            listener?.onArticleClicked(article)
        }
    }

    var article: Article? = null
        set(value) {
            field = value
            setupView()
        }

    fun setupView() {
        article?.let {
            GlideApp.with(context)
                    .load(it.imageUrl)
                    .into(itemView.image)
            itemView.title.text = it.title
            itemView.author.text = it.author
            itemView.date.text = it.date
        }
    }
}
