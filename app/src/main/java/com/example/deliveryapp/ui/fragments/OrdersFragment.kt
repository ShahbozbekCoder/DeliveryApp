package com.example.deliveryapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentOrdersBinding
import com.example.deliveryapp.ui.fragments.adapter.OnItemClickListener
import com.example.deliveryapp.ui.fragments.adapter.ParentAdapter
import com.example.deliveryapp.ui.fragments.model.Orders

class OrdersFragment : Fragment() {

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!
    private lateinit var list: ArrayList<Orders>
    private lateinit var myAdapter: ParentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        addList()
        _binding = FragmentOrdersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonProfile.setOnClickListener {
            findNavController().navigate(R.id.action_ordersFragment_to_aboutOrderFragment)
        }
        myAdapter = ParentAdapter()
        myAdapter.submitList(list)
        binding.ordersRc.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
        myAdapter.setListener(object : OnItemClickListener {
            override fun itemClickListener(position: Int) {
                val bundle = Bundle()
                bundle.putString("GeneralPrice",list[position].generalPrice)
                bundle.putString("DeliveryPrice",list[position].deliveryPrice)
                bundle.putString("from",list[position].from)
                bundle.putString("to",list[position].to)
                bundle.putString("distance",list[position].distance)
                findNavController().navigate(R.id.action_ordersFragment_to_aboutOrderFragment,bundle)
            }
        })
        binding.buttonProfile.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("toWeekly","orders")
            findNavController().navigate(R.id.action_ordersFragment_to_profileFragment,bundle)
        }
    }

    private fun addList() {
        list = ArrayList()
        list.add(Orders("Beruniy","Sebzor","5 km","75 000","20 000"))
        list.add(Orders("Chilonzor","Oloy","6 km","60 000","15 000"))
        list.add(Orders("Algoritm","Farhod","3 km","40 000","10 000"))
        list.add(Orders("Mirzo Ulug'bek","Sergeli","20 km","75 000","25 000"))
        list.add(Orders("Olmazor","Ko'kcha","10 km","70 000","18 000"))
        list.add(Orders("Darxon","Bodomzor","8 km","90 000","13 000"))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}