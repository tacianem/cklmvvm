package com.example.tacianemartimiano.cklmvvm.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.tacianemartimiano.cklmvvm.model.entities.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles WHERE article_id = :id")
    fun getArticleByID(id: Long): Article

    @Query("SELECT * FROM articles")
    fun getAllArticles(): MutableList<Article>

//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    fun updateArticle(article: Article)

    @Insert
    fun insertArticle(vararg articles: Article)

//    @Delete
//    fun deleteArticle(article: Article)

}
