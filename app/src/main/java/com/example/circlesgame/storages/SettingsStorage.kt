package com.example.circlesgame.storages

import android.content.res.Resources
import android.graphics.Color
import androidx.annotation.Keep
import com.example.circlesgame.R
import kotlinx.serialization.Serializable

object SettingsStorage {
    var mainBackgroundColor = Color.WHITE
    var buttonColorD = Color.WHITE
    var listRecords = Records(mutableListOf())
}

@Serializable
data class Records(val list: MutableList<Int>)