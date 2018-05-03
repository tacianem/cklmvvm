package com.example.tacianemartimiano.cklmvvm.model.entities

import android.nfc.Tag

@Entity
class Article {

    @PrimaryKey (autoGenerate = true)
    var id: Int? = null

    var title: String = ""
    var website: String = ""
    var author: String = ""
    var date: String = ""
    var contents: String = ""
    var tags: List<Tag> = listOf()
    var imageUrl: String = ""
    var read: Boolean = false

    override fun toString(): String {
        return "\nTitle: $title  \nAuthor: $author"
    }
}