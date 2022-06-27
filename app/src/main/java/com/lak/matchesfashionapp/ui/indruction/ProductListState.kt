package com.lak.matchesfashionapp.ui.indruction

import com.lak.matchesfashionapp.data.remote.apiresponse.ProductDetails


sealed class ProductListState {
    data class ProductList(var products: List<ProductDetails>): ProductListState()
    object Error : ProductListState()

}