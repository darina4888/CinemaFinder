package com.example.cinemafinder.ui.main

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemafinder.model.Repository
import com.example.cinemafinder.model.RepositoryImpl
import com.example.cinemafinder.model.entities.AppState
import java.lang.Thread.sleep


class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) :
    ViewModel(), LifecycleObserver {

    private val lifeCycleLiveData = MutableLiveData<String>()

    fun getData(): LiveData<AppState> {
        getFilms()
        return liveDataToObserve
    }

    fun getFilms() = getDataFromLocalSource()

    fun getLifeCycleData() = lifeCycleLiveData

    fun getLiveData() = liveDataToObserve

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(
               repositoryImpl.getFilms())
            )
        }.start()
    }
}