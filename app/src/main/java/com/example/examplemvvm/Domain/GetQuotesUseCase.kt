package com.example.examplemvvm.Domain

import com.example.examplemvvm.Domain.model.Quote
import com.example.examplemvvm.data.Database.entities.toDatabase
import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor( private  val repository:QuoteRepository){

    suspend operator fun invoke():List<Quote>{

        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }

    }

}

