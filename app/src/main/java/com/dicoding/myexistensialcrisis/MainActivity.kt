package com.dicoding.myexistensialcrisis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPhilos: RecyclerView
    private val list = ArrayList<Philosophy>()

    companion object {
        const val INTENT_PARCELABLE = "intent_parcelable"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3_000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        rvPhilos = findViewById(R.id.rv_philos)
        rvPhilos.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecycleList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.act_profile -> {
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Philosophy> {
        val dataname = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.philos_description)
        val dataPhoto = resources.obtainTypedArray(R.array.photos)
        val listPhilos = ArrayList<Philosophy>()
        for (i in dataname.indices) {
            val philos = Philosophy(dataname[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPhilos.add(philos)
        }

        return listPhilos
    }

    private fun showRecycleList() {
        rvPhilos.layoutManager = LinearLayoutManager(this)
        val listPhilosAdapter = PhilosAdapter(list)
        rvPhilos.adapter = listPhilosAdapter

        listPhilosAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}