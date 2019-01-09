package com.recipeapp.brendanreetz.roomwordssample.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word

@Dao
interface WordDao : BaseDao<Word> {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Query("DELETE FROM word_table")
    fun deleteAllWords()
}