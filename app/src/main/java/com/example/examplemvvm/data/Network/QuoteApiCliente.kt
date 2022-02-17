package com.example.examplemvvm.data.Network

import com.example.examplemvvm.data.Model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiCliente {
    @GET("/.json")
    suspend fun  getAllQuotes():Response<List<QuoteModel>>
}