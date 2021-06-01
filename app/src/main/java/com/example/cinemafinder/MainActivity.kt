package com.example.cinemafinder

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemafinder.adapters.VerticalRVAdapter
import com.example.cinemafinder.databinding.MainActivityBinding
import com.example.cinemafinder.model.entities.Films
import kotlinx.android.synthetic.main.main_activity.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        vertical_rv.layoutManager = layoutManager

        FetchDemoData(this, vertical_rv).execute()
    }

    private class FetchDemoData
    internal constructor(mContext: MainActivity, verticalRecyclerView: RecyclerView) :
            AsyncTask<Void, Void, Void>() {

        private val activityReference: WeakReference<MainActivity> = WeakReference(mContext)

        var verticalRv = verticalRecyclerView
        //step 2
        val films = Films().objects

        override fun doInBackground(vararg params: Void): Void? {
            for (film in films) {
                    VerticalRVAdapter(
                            film.category,
                            film.films
                    )
            }
            return null
        }
    }
}