package com.example.tacianemartimiano.cklmvvm.models.entities

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag


class ArticleTags {

    @Embedded
    var tag: Tag? = null

    @Relation(parentColumn = "id", entityColumn = "tagId", entity = Article::class)
    var tags: List<Tag> = ArrayList()

}