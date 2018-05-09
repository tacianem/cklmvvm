package com.example.tacianemartimiano.cklmvvm.model.dao

import android.arch.persistence.room.*
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.models.entities.ArticleTags

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article WHERE id = :id")
    fun getArticleByID(id: Long): Article

//    @Query("SELECT * FROM article")
//    fun allArticles(): LiveData<List<Article>>

    @Transaction
    @Query("SELECT * FROM article")
    fun allArticles(): List<ArticleTags>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateArticle(article: Article)

    @Insert
    fun insertArticle(vararg profiles: Article)

    @Delete
    fun deleteArticle(article: Article)
 
}
