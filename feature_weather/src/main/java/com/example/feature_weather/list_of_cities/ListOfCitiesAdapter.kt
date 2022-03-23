package com.example.feature_weather.list_of_cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.city.CityModel
import com.example.feature_weather.R
import com.example.feature_weather.databinding.ListOfCitiesAdapterItemBinding
import kotlin.collections.ArrayList

class ListOfCitiesAdapter(
    private val listener: (Pair<CityModel, Boolean>) -> Unit,
    private val listOfCities: Cities
): RecyclerView.Adapter<ListOfCitiesAdapter.ViewHolder>() {

    private var idSelected: Int? = null
    private var cityCard = ArrayList<LinearLayoutCompat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ListOfCitiesAdapterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItem(listOfCities.getList()[position])
    }

    override fun getItemViewType(position: Int): Int = position

    inner class ViewHolder(
        private val binding: ListOfCitiesAdapterItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(cityModel: CityModel) {
            binding.city.text = cityModel.name
            binding.seeDetails.setOnClickListener {
                listener(Pair(cityModel, true))
            }
            binding.cityCard.setOnClickListener {
                listener(Pair(cityModel, false))
                if(idSelected != adapterPosition) {
                    cityCard[idSelected ?: 0].setBackgroundResource(R.color.orange_light)
                    binding.linear.setBackgroundResource(R.drawable.border_card_selected)
                }
                idSelected = adapterPosition
            }
            cityCard.add(binding.linear)
        }
    }

    override fun getItemCount() =
        Cities.getList().size
}