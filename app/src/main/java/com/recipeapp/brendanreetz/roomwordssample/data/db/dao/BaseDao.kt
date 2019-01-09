package com.recipeapp.brendanreetz.roomwordssample.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<in T> {
    @Update
    fun update(vararg t: T)

    @Insert
    fun insert(vararg t: T)

    @Delete
    fun delete(vararg t: T)
}