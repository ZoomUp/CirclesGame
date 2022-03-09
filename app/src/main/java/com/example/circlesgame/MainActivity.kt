package com.example.circlesgame

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.circlesgame.databinding.ActivityMainBinding
import com.example.circlesgame.storages.SettingsStorage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences
    private val gsonRecords = Json.encodeToString(SettingsStorage.listRecords)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        SettingsStorage.apply {
            mainBackgroundColor = sharedPref.getInt("BACKGROUND_COLOR", Color.WHITE)
            val recordsInJson = sharedPref.getString("RECORDS_USER", gsonRecords)
            recordsInJson?.let { listRecords = Json.decodeFromString(it) }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStop() {
        with(sharedPref.edit()) {
            putInt("BACKGROUND_COLOR", SettingsStorage.mainBackgroundColor)
            putString("RECORDS_USER", Json.encodeToString(SettingsStorage.listRecords))
            apply()
        }
        super.onStop()
    }

}