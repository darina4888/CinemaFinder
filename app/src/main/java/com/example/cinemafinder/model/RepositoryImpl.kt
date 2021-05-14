package com.example.cinemafinder.model

import com.example.cinemafinder.model.entities.Film
import com.example.cinemafinder.model.entities.getFilmsList


//класс для обращения к базе или API
class RepositoryImpl : Repository {

    override fun getFilms(): List<Film> {
        return getFilmsList()
    }

}
