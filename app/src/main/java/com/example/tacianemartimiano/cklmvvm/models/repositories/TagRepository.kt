package com.example.tacianemartimiano.cklmvvm.models.repositories

/*
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.tacianemartimiano.cklmvvm.model.dao..TagDao
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag

class TagRepository(private val tagDao: TagDao) {

    fun getTagById(id: Int): LiveData<Tag> {
        return tagDao.getTagById(id)
    }

    fun insertTags(tag: Tag) {
        insertAsyncTask(tagDao).execute(tag)
    }

    fun updateTag(tag: Tag) {
        updateAsyncTask(tagDao).execute(tag)
    }

    fun deleteTag(tag: Tag) {
        deleteAsyncTask(tagDao).execute(tag)
    }

    fun getAllTags(): LiveData<List<Tag>> {
        return tagDao.allTags
    }

    //insert into database
    private class insertAsyncTask internal constructor(private val tagDao: TagDao) : AsyncTask<Tag, Void, Void>() {

        override fun doInBackground(vararg params: Tag): Void? {
            tagDao.insertTag(params[0])
            return null
        }
    }

    //Update entity in database
    private class updateAsyncTask internal constructor(private val tagDao: TagDao) : AsyncTask<Tag, Void, Void>() {

        override fun doInBackground(vararg params: Tag): Void? {
            tagDao.updateTag(params[0])
            return null
        }
    }

    //Delete from database
    private class deleteAsyncTask internal constructor(private val tagDao: TagDao) : AsyncTask<Tag, Void, Void>() {

        override fun doInBackground(vararg params: Tag): Void? {
            tagDao.deleteTag(params[0])
            return null
        }
    }
}*/