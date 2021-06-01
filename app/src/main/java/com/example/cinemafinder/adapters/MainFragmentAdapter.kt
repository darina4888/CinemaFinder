package com.example.cinemafinder.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemafinder.databinding.ItemListFilmsBinding
import com.example.cinemafinder.model.entities.Film
import com.example.cinemafinder.model.interfaces.OnItemViewClickListener

class MainFragmentAdapter (private val itemClickListener: OnItemViewClickListener)
        : RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var filmData: List<Film> = listOf()
    private lateinit var binding: ItemListFilmsBinding

    fun setFilm(data: List<Film>) {
        filmData = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MainViewHolder {
        binding = ItemListFilmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(filmData[position])
    }

    override fun getItemCount(): Int {
        return filmData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(film: Film) = with(binding) {
            mainFragmentRecyclerItemTextView.text = film.title
            root.setOnClickListener {
                itemClickListener.onItemViewClick(film)
            }
        }
    }
}