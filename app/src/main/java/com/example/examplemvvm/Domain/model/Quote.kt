package com.example.examplemvvm.Domain.model

import com.example.examplemvvm.data.Database.entities.QuoteEntity
import com.example.examplemvvm.data.Model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)