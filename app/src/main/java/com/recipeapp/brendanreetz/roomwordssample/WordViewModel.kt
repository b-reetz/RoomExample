package com.recipeapp.brendanreetz.roomwordssample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.recipeapp.brendanreetz.roomwordssample.data.WordRepository
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = WordRepository.getWordRepository(application)
    val allWords = repository.allWords

    fun insert(word: Word) = repository.insert(word)
}