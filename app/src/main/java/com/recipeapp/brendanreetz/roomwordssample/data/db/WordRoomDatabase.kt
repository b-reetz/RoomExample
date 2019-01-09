package com.recipeapp.brendanreetz.roomwordssample.data.db

import android.app.Application
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.recipeapp.brendanreetz.roomwordssample.data.db.dao.WordDao
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word


@Database(entities = [Word::class], version = 2)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(application: Application): WordRoomDatabase {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            application.applicationContext,
                            WordRoomDatabase::class.java, "word_database"
                        )
                            .fallbackToDestructiveMigration()
                            .addCallback(roomDatabaseCallback)
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }

        private val roomDatabaseCallback: RoomDatabase.Callback = object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE!!).execute()
            }
        }

        class PopulateDbAsync(val db: WordRoomDatabase) : AsyncTask<Void, Void, Void>() {
            private val words: Array<String> = arrayOf("dolphin", "crocodile", "cobra")

            override fun doInBackground(vararg params: Void?): Void? {
                db.wordDao().deleteAllWords()
                words.forEach { db.wordDao().insert(Word(word = it)) }
                return null
            }
        }
    }
}