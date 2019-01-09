package com.recipeapp.brendanreetz.roomwordssample.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.recipeapp.brendanreetz.roomwordssample.data.db.WordRoomDatabase
import com.recipeapp.brendanreetz.roomwordssample.data.db.dao.WordDao
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word

class WordRepository(application: Application) {

    private var wordDao: WordDao
    private var allWords: LiveData<List<Word>>

    init {
        val db: WordRoomDatabase = WordRoomDatabase.getDatabase(application)
        wordDao = db.wordDao()
        allWords = wordDao.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> = allWords
    fun insert(word: Word): AsyncTask<Word, Void, Void> = InsertAsyncTask(wordDao).execute(word)

    companion object {
        private class InsertAsyncTask(val dao: WordDao) : AsyncTask<Word, Void, Void>() {
            override fun doInBackground(vararg params: Word): Void? {
                dao.insert(params[0])
                return null
            }
        }
    }
}