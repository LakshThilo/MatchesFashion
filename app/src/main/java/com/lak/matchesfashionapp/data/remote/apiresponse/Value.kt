package com.lak.matchesfashionapp.data.remote.apiresponse

data class Value(
    val code: String,
    val count: Int,
    val name: String,
    val query: Query,
    val selected: Boolean
)