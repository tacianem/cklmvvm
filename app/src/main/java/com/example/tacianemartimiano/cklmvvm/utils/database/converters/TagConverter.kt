package com.example.tacianemartimiano.cklmvvm.utils.database.converters

import android.arch.persistence.room.TypeConverter
import com.example.tacianemartimiano.cklmvvm.models.Tag
import java.util.*

class TagConverter {

    @TypeConverter
    fun stringToTags(label: String): ArrayList<Tag> {
        val tag = Tag(label)
        return arrayListOf(tag)
    }

    @TypeConverter
    fun tagsToString(tags: ArrayList<Tag>): String {
        return tags[0].label
    }

}