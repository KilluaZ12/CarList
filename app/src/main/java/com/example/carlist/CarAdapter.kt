package com.example.carlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CarAdapter(private val carList: List<CarModel>) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder.bind(car)
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(car)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.car_iv)
        private val nameTextView: TextView = itemView.findViewById(R.id.name_tv)
        private val yearTextView: TextView = itemView.findViewById(R.id.year_tv)

        fun bind(car: CarModel) {
            Glide.with(itemView.context)
                .load(car.image)
                .into(imageView)

            nameTextView.text = car.name
            yearTextView.text = car.year
        }
    }
}