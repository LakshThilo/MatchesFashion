package com.lak.matchesfashionapp.data.remote.apiresponse

data class Facet(
    val category: Boolean,
    val code: String,
    val multiSelect: Boolean,
    val name: String,
    val priority: Int,
    val topValues: String,
    val values: List<Value>,
    val viewAllUrl: String,
    val visible: Boolean
)