package com.example.tacianemartimiano.cklmvvm.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.models.entities.ArticleTag

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article WHERE id = :id")
    fun getArticleByID(id: Long): Article

    @Query("SELECT * FROM article INNER JOIN article_tag ON article_tag.article_id = article.id INNER JOIN tag ON tag.id = article_tag.tag_id")
    fun allArticles(): LiveData<List<ArticleTag>>

//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    fun updateArticle(article: Article)

    @Insert
    fun insertArticle(vararg profiles: Article)

//    @Delete
//    fun deleteArticle(article: Article)

}
