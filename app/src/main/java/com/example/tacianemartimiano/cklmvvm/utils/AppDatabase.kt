package com.example.tacianemartimiano.cklmvvm.utils

import android.content.Context
import com.example.tacianemartimiano.cklmvvm.model.entities.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): Article

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "ckl_articles_db")
                        .build()
    }

}