package com.example.deliveryapp.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryapp.databinding.OrderItemLayoutBinding
import com.example.deliveryapp.ui.fragments.model.Orders

class ParentAdapter : ListAdapter<Orders, ParentAdapter.MyViewHolder>(MyDiffUtil()) {

    private var onItemClickListener: OnItemClickListener? = null

    inner class MyViewHolder(private val binding: OrderItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(orders: Orders) {
            binding.textViewFrom.text = orders.from
            binding.textViewTo.text = orders.to
            binding.textViewDistance.text = orders.distance
            binding.textViewPrice.text = orders.deliveryPrice
        }
        init {
            binding.root.setOnClickListener {
                onItemClickListener?.itemClickListener(adapterPosition)
            }
        }
    }

    fun setListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    class MyDiffUtil : DiffUtil.ItemCallback<Orders>() {
        override fun areItemsTheSame(oldItem: Orders, newItem: Orders): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Orders, newItem: Orders): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            OrderItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

interface OnItemClickListener {
    fun itemClickListener(position: Int)
}