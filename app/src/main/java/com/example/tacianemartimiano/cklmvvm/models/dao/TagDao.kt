package com.example.tacianemartimiano.cklmvvm.models.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

@Dao
interface TagDao {

    @get:Query("select * from tag")
    val getAllTags: LiveData<List<Tag>>

    @Query("select * from tag where id = :id")
    fun getTagById(id: Int): LiveData<Tag>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTags(vararg tag: Tag)

    @Update
    fun updateTag(tag: Tag)

    @Delete
    fun deleteTag(tag: Tag)
}