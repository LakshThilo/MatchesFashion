package com.lak.matchesfashionapp.ui.indruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lak.matchesfashionapp.data.remote.apiresponse.ProductDetails
import com.lak.matchesfashionapp.databinding.FragmentProductListBinding
import com.lak.matchesfashionapp.ui.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding
    private lateinit var viewModel: ProductListViewModel
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)

        setRecyclerview()

        viewModel.fetchProductList()

        viewModel.state.observe(viewLifecycleOwner, Observer { response ->

            when (response) {
                is ProductListState.ProductList -> {
                    submitProducts(response.products)
                }
                is ProductListState.Error -> { }
            }
        })
    }

    private fun submitProducts(products: List<ProductDetails>) {
        productAdapter.differ.submitList(products)
    }

    private fun setRecyclerview() {

        productAdapter = ProductAdapter { }

        binding.topNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }
    }
}