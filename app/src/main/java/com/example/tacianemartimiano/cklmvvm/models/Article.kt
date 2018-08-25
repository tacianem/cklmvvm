package com.example.tacianemartimiano.cklmvvm.model.entities

import android.arch.persistence.room.*

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

    @Entity(tableName = "article_tag",
            primaryKeys = ["art_id", "art_tag_id"],
            foreignKeys = [(ForeignKey(entity = Article::class, parentColumns = ["article_id"], childColumns = ["art_id"])),
                (ForeignKey(entity = Tag::class, parentColumns = ["tag_id"], childColumns = ["art_tag_id"]))])

    abstract class ArticleTag {
        @ColumnInfo(name = "art_id")
        var artId: Long = 0
        @ColumnInfo(name = "art_tag_id")
        var artTagId: Long = 0

    }

}