package com.example.carlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var carAdapter: CarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        carAdapter = CarAdapter(getCarList())
        recyclerView.adapter = carAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun getCarList(): List<CarModel> {
    }
}