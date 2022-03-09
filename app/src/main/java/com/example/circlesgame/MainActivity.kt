package com.example.circlesgame

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.circlesgame.databinding.ActivityMainBinding
import com.example.circlesgame.storages.SettingsStorage

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        SettingsStorage.mainBackgroundColor = sharedPref.getInt("BACKGROUND_COLOR", Color.WHITE)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStop() {
        with (sharedPref.edit()) {
            putInt("BACKGROUND_COLOR", SettingsStorage.mainBackgroundColor)
            apply()
        }
        super.onStop()
    }

}