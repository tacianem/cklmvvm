package com.example.tacianemartimiano.cklmvvm.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.example.tacianemartimiano.cklmvvm.utils.database.converters.TagConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "articles")
class Article {

    companion object {
        var id = -1
    }

    @PrimaryKey
    @ColumnInfo(name = "article_id")
    var articleId: Int = -1

    var title: String = ""

    var website: String = ""

    @SerializedName("authors")
    var author: String = ""

    var date: String = ""

    @SerializedName("content")
    var contents: String = ""

    @TypeConverters(TagConverter::class)
    var tags: ArrayList<Tag> = arrayListOf(Tag())

    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    var imageUrl: String = ""

    var read: Boolean = false

    override fun toString(): String { //TODO FAZER UM TO STRING PARA O VIEWHOLDER
        return "\nTitle: $title  \nAuthor: $author"
    }

}