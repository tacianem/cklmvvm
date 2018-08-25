package com.example.tacianemartimiano.cklmvvm.model.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tags")
class Tag {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tag_id")
    var tagId: Long = 0

    var label: String = ""
    var color: Int = 0
}