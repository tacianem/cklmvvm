package com.example.tacianemartimiano.cklmvvm.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

@Entity(tableName = "articles")
class Article {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "article_id")
    var articleId: Long = 0

    var title: String = ""
    var website: String = ""
    var author: String = ""
    var date: String = ""
    var contents: String = ""
    @Ignore
    var tags: List<Tag> = listOf()
    @ColumnInfo(name = "image_url")
    var imageUrl: String = ""
    var read: Boolean = false

    override fun toString(): String {
        return "\nTitle: $title  \nAuthor: $author"
    }

}