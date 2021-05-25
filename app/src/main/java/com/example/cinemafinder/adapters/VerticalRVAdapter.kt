package com.example.cinemafinder.adapters

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemafinder.R
import com.example.cinemafinder.model.HorizontalRVModel
import io.github.luizgrp.sectionedrecyclerviewadapter.Section
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import kotlinx.android.synthetic.main.vertical_header.view.*

class VerticalRVAdapter(private val category: String, private val films: ArrayList<HorizontalRVModel>) : Section(SectionParameters.builder().itemResourceId(R.layout.vertical_item).headerResourceId(R.layout.vertical_header).build()){

    class ItemViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        private val horizontalRecyclerView: RecyclerView
        val horizontalAdapter: HorizontalRVAdapter

        init {
            val context = itemView.context
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_rv)
            horizontalRecyclerView?.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            horizontalAdapter = HorizontalRVAdapter(context)
            horizontalRecyclerView.adapter = horizontalAdapter
        }
    }

    class SectionViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView)

    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        return SectionViewHolder(view)
    }

    override fun getContentItemsTotal(): Int {
        return films.size
    }

    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
        return ItemViewHolder(view)
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder) {
        holder.itemView.vertical_category_text.setTextColor(Color.WHITE)
        holder.itemView.vertical_category_text.text = category //category1
    }


    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemViewHolder

        itemHolder.horizontalAdapter.setRowIndex(position)
    }
}