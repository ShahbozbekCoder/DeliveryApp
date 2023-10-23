package com.example.deliveryapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentOneOrderBinding
import com.example.deliveryapp.ui.fragments.adapter.InnerAdapter

class OneOrderFragment : Fragment() {

    private var _binding: FragmentOneOrderBinding? = null
    private val binding get() = _binding!!
    private lateinit var myAdapter: InnerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOneOrderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = InnerAdapter()
        binding.productsRc.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
        binding.buttonDelivered.setOnClickListener {
            findNavController().navigate(R.id.action_oneOrderFragment_to_orderBottomSheetFragment)
        }
        arguments?.getString("GeneralPrice").let {price ->
            binding.priceOfProduct.text = price
        }
        arguments?.getString("DeliveryPrice").let {price ->
            binding.priceOfDelivery.text = price
        }
        arguments?.getString("from").let {
            binding.textViewFrom.text = it
        }
        arguments?.getString("to").let {
            binding.textViewTo.text = it
        }
        arguments?.getString("distance").let {
            binding.textViewDistance.text = it
        }
        binding.buttonProfile.setOnClickListener {
            findNavController().navigate(R.id.action_oneOrderFragment_to_profileFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}