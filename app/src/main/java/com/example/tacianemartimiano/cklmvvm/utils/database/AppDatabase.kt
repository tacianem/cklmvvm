package com.example.tacianemartimiano.cklmvvm.utils.database

/*@Database(entities = [Article::class, Tag::class], version = 1)
@TypeConverters(TagListConverter::class)
abstract class AppDatabase : RoomDatabase() {

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

}*/
