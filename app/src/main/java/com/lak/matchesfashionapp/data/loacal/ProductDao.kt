package com.lak.matchesfashionapp.data.loacal

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lak.matchesfashionapp.data.remote.apiresponse.ProductDetails

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ProductDetails): Long

    // @Query("SELECT * FROM products")
    fun getAllArticles(): LiveData<List<ProductDetails>>

    @Delete
    suspend fun deleteArticle(article: ProductDetails)
}