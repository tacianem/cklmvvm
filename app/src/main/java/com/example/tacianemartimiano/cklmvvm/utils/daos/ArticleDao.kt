package com.example.tacianemartimiano.cklmvvm.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.tacianemartimiano.cklmvvm.models.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles WHERE article_id = :id")
    fun articleByID(id: Long): LiveData<Article>

    @Query("SELECT * FROM articles")
    fun allArticles(): LiveData<MutableList<Article>>

    @Insert
    fun insert(vararg articles: Article)

//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    fun update(article: Article)

//    @Delete
//    fun delete(article: Article)

}
