package com.lak.matchesfashionapp.reposotory

import com.lak.matchesfashionapp.data.remote.apiresponse.ProductsResponse
import com.lak.matchesfashionapp.data.remote.apiservice.MatchesFashionAPI
import com.lak.matchesfashionapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepo @Inject constructor(
    private val api: MatchesFashionAPI
){
    suspend fun getToHeadlineFromApi(format: String,): Resource<ProductsResponse> {
        val response = try {
            withContext(Dispatchers.IO){
                api.getProductsFromApi(format)
            }
        } catch (e: Exception) {
            return Resource.Error("Unexpected Error occurred!!")
        }
        return Resource.Success(response)
    }
}