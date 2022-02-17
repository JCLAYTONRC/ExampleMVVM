package com.example.examplemvvm.data.Database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examplemvvm.data.Database.entities.QuoteEntity

@Dao
interface QuoteDao {

    @Query("Select * from quote_table Order by author desc")
    suspend fun getAllQuotes():List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<QuoteEntity>)

    @Query("Delete from quote_table")
    suspend fun deleteAllQuotes()

}