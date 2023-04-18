package com.dascamp.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dascamp.myapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private var detailBinding: ActivityDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(detailBinding!!.root)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {

        val film = intent.extras?.get("film") as Film

        detailBinding?.detailsToolbar?.title = film.title
        detailBinding?.detailsPoster?.setImageResource(film.poster)
        detailBinding?.detailsDescription?.text = film.description
    }
}