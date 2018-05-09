package com.example.tacianemartimiano.cklmvvm.model.entities

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(entity=Tag::class, parentColumns=["id"], childColumns=["tagId"])))
class Article {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var tagId: Int? = null

    @Embedded
    var title: String = ""
    var website: String = ""
    var author: String = ""
    var date: String = ""
    var contents: String = ""
    //var tags: List<Tag> = listOf()
    var imageUrl: String = ""
    var read: Boolean = false

    override fun toString(): String {
        return "\nTitle: $title  \nAuthor: $author"
    }
}