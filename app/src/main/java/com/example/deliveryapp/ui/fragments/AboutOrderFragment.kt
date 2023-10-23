package com.example.deliveryapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentAboutOrderBinding
import com.example.deliveryapp.ui.fragments.adapter.InnerAdapter
import com.example.deliveryapp.ui.fragments.model.OneProduct

class AboutOrderFragment : Fragment() {

    private var _binding: FragmentAboutOrderBinding? = null
    private val binding get() = _binding!!
    private lateinit var myAdapter: InnerAdapter
    private lateinit var aboutProducts1: ArrayList<OneProduct>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        addList()
        _binding = FragmentAboutOrderBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun addList() {
        aboutProducts1 = ArrayList()
        val oneProduct1 = OneProduct(image = R.drawable.pepsi,"Pepsi 1.5L","15 000 UZS")
        aboutProducts1.add(oneProduct1)
        aboutProducts1.add(oneProduct1)
        aboutProducts1.add(oneProduct1)
        aboutProducts1.add(oneProduct1)
        aboutProducts1.add(oneProduct1)
        aboutProducts1.add(oneProduct1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = InnerAdapter()
        myAdapter.submitList(aboutProducts1)
        Log.d("TAG", "onViewCreated: ${aboutProducts1.size}")
        binding.productsRc.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }
        arguments?.getString("GeneralPrice").let {price ->
            binding.textViewGeneralSumma.text = price
        }
        arguments?.getString("DeliveryPrice").let {price ->
            binding.textViewDeliveryPrice.text = price
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
        binding.buttonAccept.setOnClickListener {
            findNavController().navigate(R.id.action_aboutOrderFragment_to_oneOrderFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}