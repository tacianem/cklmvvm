package com.example.tacianemartimiano.cklmvvm.utils.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.RoomWarnings
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.models.ArticleTag

@Dao
interface ArticleTagDao {

    @Insert
    fun insert(articleTag: ArticleTag)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM articles INNER JOIN article_tag ON articles.article_id = article_tag.art_id WHERE article_tag.art_tag_id = :tagId")
    fun articlesFromTag(tagId: Long): LiveData<MutableList<Article>>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM tags INNER JOIN article_tag ON tags.tag_id = article_tag.art_tag_id WHERE article_tag.art_id =:articleId")
    fun tagsFromArticle(articleId: Long): LiveData<MutableList<Tag>>

}