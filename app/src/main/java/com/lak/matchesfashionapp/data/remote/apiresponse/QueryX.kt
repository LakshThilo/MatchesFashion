package com.lak.matchesfashionapp.data.remote.apiresponse

data class QueryX(
    val balanceFactorList: String,
    val curationList: String,
    val filterQueries: List<Any>,
    val responseMode: String,
    val searchQueryContext: String,
    val value: String
)