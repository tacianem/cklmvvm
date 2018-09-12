package com.example.tacianemartimiano.cklmvvm

import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.repositories.local.ArticleLocalRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as _when

class ExampleUnitTest {

    lateinit var article: Article
    lateinit var articleRepository: ArticleLocalRepository

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun onArticleAdded() {
        articleRepository.insertArticle(article)
        assertEquals("Article inserted successfully", article, articleRepository.getArticleById(article.articleId))
    }

}
//
//`when`(server.requestForecastByZipCode(any(Long::class.java), any(Long::class.java)))
//.then { ForecastList(0, "city", "country", listOf()) }
