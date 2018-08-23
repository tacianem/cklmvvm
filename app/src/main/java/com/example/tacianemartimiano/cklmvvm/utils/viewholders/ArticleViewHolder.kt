package com.example.tacianemartimiano.cklmvvm.utils.viewholders

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.glide.GlideApp
import kotlinx.android.synthetic.main.article_list_item.view.*

class ArticleViewHolder(var view: View, private val context: Context, private val onArticleClicked: (Article) -> Unit) : RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            article?.let {
                onArticleClicked(it)
            }
        }
    }

    private var article: Article? = null
        set(value) {
            field = value
            article?.let {
                GlideApp.with(context)
                        .load(it.imageUrl)
                        .into(view.image)
                view.title.text = it.title
                view.author.text = it.author
                view.date.text = it.date

                var type = Typeface.BOLD
                if (it.read) {
                    type = Typeface.NORMAL
                }
                view.title.setTypeface(null, type)
                view.author.setTypeface(null, type)
                view.date.setTypeface(null, type)
            }
        }

    fun bind(art: Article) {
        article = art
    }

}
