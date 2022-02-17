package com.example.examplemvvm.data

import com.example.examplemvvm.Domain.model.Quote
import com.example.examplemvvm.Domain.model.toDomain
import com.example.examplemvvm.data.Database.Dao.QuoteDao
import com.example.examplemvvm.data.Database.entities.QuoteEntity
import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.Network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteDao: QuoteDao   ){

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response : List<QuoteModel> = api.getQuotes()
        return  response.map { it.toDomain() }
    }

    suspend fun  getAllQuotesFromDatabase():List<Quote> {
        val response : List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}