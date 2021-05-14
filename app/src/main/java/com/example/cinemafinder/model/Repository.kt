package com.example.cinemafinder.model

import com.example.cinemafinder.model.entities.Film


interface Repository {
    fun getFilms(): List<Film>
}