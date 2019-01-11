package com.recipeapp.brendanreetz.roomwordssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.recipeapp.brendanreetz.roomwordssample.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.startKoin

class MainActivity : AppCompatActivity() {

    private val navConfiguration by lazy { findNavController(R.id.nav_host_fragment) }
    private val appBarConfiguration by lazy {
        AppBarConfiguration(navConfiguration.graph)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        setSupportActionBar(toolbar)

        startKoin(this, listOf(appModule))

        setupActionBarWithNavController(navConfiguration, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        findNavController(R.id.nav_host_fragment).navigateUp()
        return super.onSupportNavigateUp()
    }
}
