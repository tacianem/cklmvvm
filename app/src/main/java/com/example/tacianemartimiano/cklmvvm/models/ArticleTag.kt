package com.example.tacianemartimiano.cklmvvm.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

@Entity(tableName = "article_tag",
        primaryKeys = ["art_id", "art_tag_id"],
        indices = [(Index("art_tag_id"))],
        foreignKeys = [(ForeignKey(entity = Article::class, parentColumns = ["article_id"], childColumns = ["art_id"])),
            (ForeignKey(entity = Tag::class, parentColumns = ["tag_id"], childColumns = ["art_tag_id"]))])

class ArticleTag {
    @ColumnInfo(name = "art_id")
    var artId: Long = 0
    @ColumnInfo(name = "art_tag_id")
    var artTagId: Long = 0

}