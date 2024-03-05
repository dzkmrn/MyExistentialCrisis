package com.dicoding.myexistensialcrisis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PHILOS = "extra_philos"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //back button
        val actionBar = supportActionBar

        actionBar!!.title = "What is it?"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        val philosophy = intent.getParcelableExtra<Philosophy>(MainActivity.INTENT_PARCELABLE)

        val imgPhilos = findViewById<ImageView>(R.id.philosopy_image)
        val namePhilos = findViewById<TextView>(R.id.philosophy_name)
        val descPhilos = findViewById<TextView>(R.id.philosophy_description)

        imgPhilos.setImageResource(philosophy?.photos!!)
        namePhilos.text = philosophy.name
        descPhilos.text = philosophy.description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}