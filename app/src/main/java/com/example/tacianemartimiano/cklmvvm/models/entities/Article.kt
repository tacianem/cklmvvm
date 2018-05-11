package com.example.tacianemartimiano.cklmvvm.model.entities

import android.arch.persistence.room.*

@Entity
class Article {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    var title: String = ""
    var website: String = ""
    var author: String = ""
    var date: String = ""
    var contents: String = ""
    @Ignore
    var tags: List<Tag> = listOf()
    var imageUrl: String = ""
    var read: Boolean = false

    override fun toString(): String {
        return "\nTitle: $title  \nAuthor: $author"
    }

    @Entity(tableName = "article_tag",
            primaryKeys = ["article_id", "tag_id"],
            indices = [(Index(value = "article_id")), (Index(value = "tag_id"))],
            foreignKeys = [(ForeignKey(entity = Article::class, parentColumns = ["id"], childColumns = ["article_id"])),
                (ForeignKey(entity = Tag::class, parentColumns = ["id"], childColumns = ["tag_id"]))])

    abstract class ArticleTag (artId: Long, tId: Long) {

        var articleTagId: Long = 0

        @ColumnInfo(name = "article_id")
        var articleId: Long = 0
        @ColumnInfo(name = "tag_id")
        var tagId: Long = 0

        init {
            articleId = artId
            tagId = tId
        }
    }

}