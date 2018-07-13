package com.example.tacianemartimiano.cklmvvm.utils.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.tacianemartimiano.cklmvvm.model.dao.ArticleDao
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag
import com.example.tacianemartimiano.cklmvvm.utils.daos.ArticleTagDao
import com.example.tacianemartimiano.cklmvvm.utils.daos.TagDao

@Database(entities = [Article::class, Tag::class, Article.ArticleTag::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun articleTagDao(): ArticleTagDao
    abstract fun articleDao(): ArticleDao
    abstract fun tagDao(): TagDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
                INSTANCE
                        ?: synchronized(this) {
                            INSTANCE
                                    ?: buildDatabase(context).also { INSTANCE = it }
                        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "ckl_articles_db")
                        .build()
    }

}
