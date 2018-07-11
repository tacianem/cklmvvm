package com.example.tacianemartimiano.cklmvvm.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "articles")
class Article {
    @PrimaryKey
    @ColumnInfo(name = "article_id")
    var articleId: Int? = null

    var title: String = ""
    var website: String = ""
    var author: String = ""
    var date: String = ""
    var contents: String = ""
    var tag: String = ""
    @ColumnInfo(name = "image_url")
    var imageUrl: String = ""
    var read: Boolean = false

    override fun toString(): String { //TODO FAZER UM TO STRING PARA O VIEWHOLDER
        return "\nTitle: $title  \nAuthor: $author"
    }

}