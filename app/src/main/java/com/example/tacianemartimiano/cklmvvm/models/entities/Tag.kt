package com.example.tacianemartimiano.cklmvvm.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Tag {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    var label: String = ""
    var color: Int = 0
}