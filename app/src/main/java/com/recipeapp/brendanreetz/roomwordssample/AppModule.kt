package com.recipeapp.brendanreetz.roomwordssample

import androidx.room.Room
import com.recipeapp.brendanreetz.roomwordssample.data.WordRepository
import com.recipeapp.brendanreetz.roomwordssample.data.db.WordRoomDatabase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { Room.databaseBuilder(get(), WordRoomDatabase::class.java, "word_database").build() }
    single { get<WordRoomDatabase>().wordDao() }
    single { WordRepository(get()) }
    single { MainActivity() }

    viewModel { WordViewModel(get()) }
}