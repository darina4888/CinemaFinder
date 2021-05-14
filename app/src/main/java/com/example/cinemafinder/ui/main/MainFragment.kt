package com.example.cinemafinder.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.cinemafinder.R
import com.example.cinemafinder.adapters.MainFragmentAdapter
import com.example.cinemafinder.databinding.MainFragmentBinding
import com.example.cinemafinder.model.entities.AppState
import com.example.cinemafinder.model.entities.Film
import com.example.cinemafinder.model.interfaces.OnItemViewClickListener
import com.example.cinemafinder.ui.details.DetailsFragment
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding



    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var adapter: MainFragmentAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //нашли вью модель и подписались  на обновления
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getFilms()
    }

    @Suppress("NAME_SHADOWING")
    private fun renderData(appState: AppState) = with(binding) { when (appState) {
        is AppState.Success -> {
            mainFragmentLoadingLayout.visibility = View.GONE
            adapter = MainFragmentAdapter( object : OnItemViewClickListener {
                override fun onItemViewClick(film: Film) {
                    val manager =  activity?.supportFragmentManager
                    //проверка if manager is not null
                    manager?.let { manager->
                        val bundle = Bundle().apply {
                            putParcelable(DetailsFragment.BUNDLE_EXTRA, film)
                        }
                        manager.beginTransaction()
                            .add(R.id.container, DetailsFragment.newInstance(bundle))
                            .addToBackStack("") //возвращаться назад
                            .commitAllowingStateLoss()// делаем коммит после сохранения активити стейт. Если простой коммит (он ассинхронный) может прийти когда уже не существует
                        // синхронизируемяс с возможностью не потерять свою активити
                    }
                }
            }
            ).apply {
                setFilm(appState.filmData)
            }
            mainFragmentRecyclerView.adapter = adapter

        }
        is AppState.Loading -> {
            mainFragmentLoadingLayout.visibility = View.VISIBLE
        }
        is AppState.Error -> {
            mainFragmentLoadingLayout.visibility = View.GONE
//            Snackbar
//                .make(binding.mainFragmentFAB, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
//                .setAction(getString(R.string.reload)) { viewModel.getWeatherFromLocalSourceRus() }
//                .show()
        }
    }
    }
}