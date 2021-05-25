package com.example.cinemafinder.model.entities

import com.example.cinemafinder.R
import com.example.cinemafinder.model.HorizontalRVModel
import com.example.cinemafinder.model.VerticalRVModel
import java.util.*

data class Films(
        var objects: ArrayList<VerticalRVModel> = arrayListOf(
                VerticalRVModel(
                        "Now playing",
                        arrayListOf(
                            HorizontalRVModel("Эмма", R.drawable.msc),
                            HorizontalRVModel("Винариум", R.drawable.nsk),
                            HorizontalRVModel("Вспомнить все", R.drawable.sam),
                            HorizontalRVModel("Тест 2", R.drawable.spb)
                        ),
                )
        )
)