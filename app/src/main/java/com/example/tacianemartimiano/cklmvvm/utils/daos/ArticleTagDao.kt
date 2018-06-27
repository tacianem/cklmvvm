package com.example.tacianemartimiano.cklmvvm.utils.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

@Dao
interface ArticleTagDao {

    @Insert
    fun insertArticleTag(articleTag: Article.ArticleTag)

    @Query("SELECT * FROM articles INNER JOIN article_tag ON articles.article_id = article_tag.art_id WHERE article_tag.art_tag_id = :tagId")
    fun getArticlesForTag(tagId: Long): MutableList<Article>

    @Query("SELECT * FROM tags INNER JOIN article_tag ON tags.tag_id = article_tag.art_tag_id WHERE article_tag.art_id =:articleId")
    fun getTagsForArticle(articleId: Long): MutableList<Tag>

}