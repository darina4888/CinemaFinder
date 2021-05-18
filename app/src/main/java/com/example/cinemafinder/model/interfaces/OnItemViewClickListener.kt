package com.example.cinemafinder.model.interfaces

import com.example.cinemafinder.model.entities.Film

interface OnItemViewClickListener {
    fun onItemViewClick(film: Film)
}