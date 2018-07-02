package com.example.tacianemartimiano.cklmvvm.utils.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

@Dao
interface TagDao {

    @Query("SELECT * FROM tags")
    fun allTags(): LiveData<MutableList<Tag>>

    @Query("SELECT * FROM tags WHERE tag_id = :id")
    fun tagById(id: Long): LiveData<Tag>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg tags: Tag)

    @Update
    fun update(tag: Tag)

    @Delete
    fun delete(tag: Tag)
}