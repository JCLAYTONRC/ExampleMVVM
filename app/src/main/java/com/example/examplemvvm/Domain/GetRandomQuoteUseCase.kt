package com.example.examplemvvm.Domain

import com.example.examplemvvm.Domain.model.Quote
import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.QuoteRepository
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote?{

        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){

            val randomNimer = (quotes.indices).random()

            return quotes[randomNimer]
        }
        return null
    }

}