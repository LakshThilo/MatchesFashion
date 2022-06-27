package com.lak.matchesfashionapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lak.matchesfashionapp.R
import com.lak.matchesfashionapp.data.remote.apiresponse.ProductDetails
import com.lak.matchesfashionapp.databinding.SingleProductBinding
import com.lak.matchesfashionapp.ui.adapter.ProductAdapter.ProductViewHolder

class ProductAdapter(val onClickListener: (ProductDetails) -> Unit): RecyclerView.Adapter<ProductViewHolder>() {

    private val diffCallback = object: DiffUtil.ItemCallback<ProductDetails>(){
        override fun areItemsTheSame(oldItem: ProductDetails, newItem: ProductDetails): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(oldItem: ProductDetails, newItem: ProductDetails): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = SingleProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val article = differ.currentList[position] as ProductDetails
        holder.bind(article, position)
        holder.itemView.setOnClickListener { onClickListener.invoke(article) }
    }

    override fun getItemCount() = differ.currentList.size

    inner class ProductViewHolder(private val binding: SingleProductBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductDetails, position: Int) {
            binding.tvProductName.text = product.name
            binding.tvDesigner.text = product.designer.name
            binding.tvProductPrice.text = product.price.formattedValue

            val image: ImageView =  itemView.findViewById(R.id.iv_product_image)
            //Glide.with(itemView.context).load("https://assetsprx.matchesfashion.com/img/product/1482209_1_medium.jpg").into(image)
            Log.d("LAKSHITHA", "bind:${product.primaryImageMap.medium.url} ")
            val imageUrl = product.primaryImageMap.medium.url
            Glide.with(itemView.context).asBitmap().load(imageUrl).into(image)

            /*Log.d("LAKSHITHA", "bind:${product.primaryImageMap.medium.url} ")
            binding.ivProductImage.load(product.primaryImageMap.medium.url)
*/
        }
    }
}
