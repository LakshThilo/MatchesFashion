package com.lak.matchesfashionapp.data.remote.apiresponse

data class Pagination(
    val currentPage: Int,
    val numberOfPages: Int,
    val pageSize: Int,
    val sort: String,
    val totalNumberOfResults: Int
)