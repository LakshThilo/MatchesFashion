package com.lak.matchesfashionapp.ui.indruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lak.matchesfashionapp.data.remote.apiresponse.ProductsResponse
import com.lak.matchesfashionapp.reposotory.ProductRepo
import com.lak.matchesfashionapp.util.Resource.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repo: ProductRepo
) : ViewModel() {


    private val _state = MutableLiveData<ProductListState>()
    val state: LiveData<ProductListState> = _state

    private val format: String = "json"

    fun fetchProductList() = viewModelScope.launch {
        val result = repo.getToHeadlineFromApi(format)
        when (result) {
            is Success -> {
                emitArticleList(result.data)
            }
            is Error -> {
                emitError()
            }
        }
    }

    private fun emitError() {
        _state.value = ProductListState.Error
    }

    private fun emitArticleList(response: ProductsResponse?) {
        response?.let {
          _state.value = ProductListState.ProductList(response.results)
        } ?: ProductListState.Error
    }
}