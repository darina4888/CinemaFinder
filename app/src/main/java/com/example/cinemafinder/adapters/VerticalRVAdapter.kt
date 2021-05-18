package com.example.cinemafinder.adapters

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemafinder.model.HorizontalRVModel

class VerticalRVAdapter(private val category: String, private val films: ArrayList<HorizontalRVModel>) {

    class ItemViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        private val horizontalRecyclerView: RecyclerView
        val horizontalAdapter: HorizontalRVAdapter

        init {
            val context = itemView.context
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_rv)
            horizontalRecyclerView?.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            horizontalRecyclerView?.addItemDecoration(
                    EqualSpacingItemDecoration(
                            8,
                            EqualSpacingItemDecoration.HORIZONTAL
                    )
            )
            horizontalAdapter = HorizontalRVAdapter(context)
            horizontalRecyclerView.adapter = horizontalAdapter
        }
    }

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemViewHolder
        // Subcategory
        itemHolder.itemView.subcategory_text.text = subcategory[position]
        // Color items
        itemHolder.horizontalAdapter.setColorsData(colors[position])
        // Pass the current row
        itemHolder.horizontalAdapter.setRowIndex(position)
    }
}