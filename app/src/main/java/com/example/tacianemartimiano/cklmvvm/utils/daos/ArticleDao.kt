package com.example.tacianemartimiano.cklmvvm.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.tacianemartimiano.cklmvvm.models.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles WHERE article_id = :id")
    fun getArticleById(id: Int?): Article

    @Query("SELECT * FROM articles WHERE author = :author AND title = :title AND date = :date")
    fun getArticle(author: String, title: String, date: String): Article

    @Query("SELECT * FROM articles")
    fun allArticles(): LiveData<MutableList<Article>>

    @Insert
    fun insert(vararg articles: Article)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(article: Article)

}
