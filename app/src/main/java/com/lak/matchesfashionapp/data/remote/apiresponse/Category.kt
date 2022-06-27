package com.lak.matchesfashionapp.data.remote.apiresponse

data class Category(
    val active: Boolean,
    val categories: List<CategoryX>,
    val code: String,
    val curationEnabled: CurationEnabledXX,
    val isSaleLink: Boolean,
    val mobileUrl: String,
    val name: String,
    val url: String
)