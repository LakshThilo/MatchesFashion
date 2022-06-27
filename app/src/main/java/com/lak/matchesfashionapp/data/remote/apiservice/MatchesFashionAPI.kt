package com.lak.matchesfashionapp.data.remote.apiservice

import com.lak.matchesfashionapp.data.remote.apiresponse.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchesFashionAPI {

    //https://www.matchesfashion.com/womens/shop?format=json

    @GET("/womens/shop")
    suspend fun getProductsFromApi(
        @Query("format") format: String
    ): ProductsResponse
}