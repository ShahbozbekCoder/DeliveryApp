package com.example.deliveryapp.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryapp.databinding.FragmentProfileMonthlyBinding
import com.example.deliveryapp.ui.fragments.model.Monthly

class AdapterMonthly : RecyclerView.Adapter<AdapterMonthly.MyViewHolder>() {

    inner class MyViewHolder(private val binding: FragmentProfileMonthlyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(monthly: Monthly) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            FragmentProfileMonthlyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }
}