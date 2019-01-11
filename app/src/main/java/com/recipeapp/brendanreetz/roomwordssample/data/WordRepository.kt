package com.recipeapp.brendanreetz.roomwordssample.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.recipeapp.brendanreetz.roomwordssample.data.db.dao.WordDao
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> by lazy { wordDao.getAllWords() }
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