package com.example.cinemafinder.model

data class VerticalRVModel(
        val category: String,
        val films: ArrayList<HorizontalRVModel>
) {

}