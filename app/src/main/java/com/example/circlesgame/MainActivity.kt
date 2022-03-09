package com.example.circlesgame

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.circlesgame.databinding.ActivityMainBinding
import com.example.circlesgame.storages.SettingsStorage

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        SettingsStorage.mainBackgroudColor = sharedPref.getInt("BACKGROUND_COLOR", Color.WHITE)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStop() {
        with (sharedPref.edit()) {
            putInt("BACKGROUND_COLOR", SettingsStorage.mainBackgroudColor)
            apply()
        }
        super.onStop()
    }

}