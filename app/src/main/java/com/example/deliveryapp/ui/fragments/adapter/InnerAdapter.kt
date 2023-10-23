package com.example.deliveryapp.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryapp.databinding.ProductItemLayoutBinding
import com.example.deliveryapp.ui.fragments.model.OneProduct

class InnerAdapter: ListAdapter<OneProduct, InnerAdapter.MyViewHolder>(MyDiffUtil()) {
    inner class MyViewHolder(private val binding: ProductItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(oneProduct: OneProduct){
                binding.productImage.setImageResource(oneProduct.image)
                binding.productName.text = oneProduct.name
                binding.productPrice.text = oneProduct.price
            }

        }
    class MyDiffUtil: DiffUtil.ItemCallback<OneProduct>(){
        override fun areItemsTheSame(oldItem: OneProduct, newItem: OneProduct): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: OneProduct, newItem: OneProduct): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}