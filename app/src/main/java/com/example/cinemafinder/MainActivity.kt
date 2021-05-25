package com.example.cinemafinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemafinder.databinding.MainActivityBinding
import com.example.cinemafinder.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        vertical_rv.layoutManager = layoutManager

//        binding = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
    }
}