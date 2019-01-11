package com.recipeapp.brendanreetz.roomwordssample

import androidx.lifecycle.ViewModel
import com.recipeapp.brendanreetz.roomwordssample.data.WordRepository
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word

class WordViewModel(private val wordRepository: WordRepository) : ViewModel() {
    val allWords = wordRepository.allWords
    fun insert(word: Word) = wordRepository.insert(word)
}