package com.recipeapp.brendanreetz.roomwordssample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.recipeapp.brendanreetz.roomwordssample.data.db.dao.WordDao
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word


@Database(entities = [Word::class], version = 2)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}