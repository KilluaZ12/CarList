package com.example.carlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {

    private lateinit var carModel: CarModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val imageView: ImageView = view.findViewById(R.id.detail_iv)
        val nameTextView: TextView = view.findViewById(R.id.detail_name_tv)
        val yearTextView: TextView = view.findViewById(R.id.detail_year_tv)

        Glide.with(requireContext())
            .load(carModel.image)
            .into(imageView)

        nameTextView.text = carModel.name
        yearTextView.text = carModel.year

        return view
    }
}