package com.example.tacianemartimiano.cklmvvm.model.dao

import android.arch.lifecycle.LiveData
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface ArticleDao {

    @get:Query("select * from article")
    val getAllArticles: LiveData<List<Article>>

    @Query("select * from article where id = :id")
    fun getArticleById(id: Int): LiveData<Article>

    @Insert(onConflict = REPLACE)
    fun insertArticles(vararg articles: Article)

    @Update
    fun updateArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)
}
