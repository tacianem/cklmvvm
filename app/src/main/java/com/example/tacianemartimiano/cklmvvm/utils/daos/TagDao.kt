package com.example.tacianemartimiano.cklmvvm.utils.daos

import android.arch.persistence.room.*
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

@Dao
interface TagDao {

    @Query("SELECT * FROM tags")
    fun getAllTags(): MutableList<Tag>

    @Query("SELECT * FROM tags WHERE tag_id = :id")
    fun getTagById(id: Int): Tag

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTags(vararg tags: Tag)

    @Update
    fun updateTag(tag: Tag)

    @Delete
    fun deleteTag(tag: Tag)
}