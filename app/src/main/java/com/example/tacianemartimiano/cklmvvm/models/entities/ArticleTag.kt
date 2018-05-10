package com.example.tacianemartimiano.cklmvvm.models.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

@Entity(tableName = "article_tag",
        indices = [/*Index("name"),*/
            Index(value = ["article_id", "tag_id"])
        ], foreignKeys = [ForeignKey(entity = Article::class, parentColumns = ["id"], childColumns = ["article_id"]),
    ForeignKey(entity = Tag::class, parentColumns = ["id"], childColumns = ["tag_id"])])

class ArticleTag {

    var articleTagId: Long = 0

    @ColumnInfo(name = "article_id")
    var articleId: Long = 0
    @ColumnInfo(name = "tag_id")
    var tagId: Long = 0
}