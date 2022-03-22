package com.example.feature_weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.city.CityModel
import com.example.feature_weather.databinding.ListOfCitiesAdapterItemBinding

class ListOfCitiesAdapter(
    private val listener: (CityModel) -> Unit
): RecyclerView.Adapter<ListOfCitiesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ListOfCitiesAdapterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItem(Cities.getList()[position])
    }

    override fun getItemViewType(position: Int): Int = position

    inner class ViewHolder(
        private val binding: ListOfCitiesAdapterItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(cityModel: CityModel) {
            binding.city.text = cityModel.name
            binding.root.setOnClickListener {
                listener(cityModel)
            }
        }
    }

    override fun getItemCount() =
        Cities.getList().size
}