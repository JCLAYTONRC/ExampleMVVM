package com.example.examplemvvm.data.Network

import com.example.examplemvvm.Core.RetrofitHelper
import com.example.examplemvvm.data.Model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiCliente ) {

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO  ){
            val response = api.getAllQuotes()
           response.body() ?: emptyList()
        }

    }

}