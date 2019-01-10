package com.recipeapp.brendanreetz.roomwordssample.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.recipeapp.brendanreetz.roomwordssample.data.db.WordRoomDatabase
import com.recipeapp.brendanreetz.roomwordssample.data.db.dao.WordDao
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word

class WordRepository(application: Application) {

    private val db: WordRoomDatabase by lazy { WordRoomDatabase.getDatabase(application) }
    private val wordDao: WordDao by lazy { db.wordDao() }

    val allWords: LiveData<List<Word>> by lazy { wordDao.getAllWords() }

    fun insert(word: Word): AsyncTask<Word, Void, Void> = InsertAsyncTask(wordDao).execute(word)

    companion object {
        private var INSTANCE: WordRepository? = null

        fun getWordRepository(application: Application): WordRepository {
            synchronized(WordRepository::class.java) {
                if (INSTANCE == null)
                    INSTANCE = WordRepository(application)
            }
            return INSTANCE!!
        }

        private class InsertAsyncTask(val dao: WordDao) : AsyncTask<Word, Void, Void>() {
            override fun doInBackground(vararg params: Word): Void? {
                dao.insert(params[0])
                return null
            }
        }
    }
}