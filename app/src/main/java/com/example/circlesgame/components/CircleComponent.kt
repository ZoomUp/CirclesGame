package com.example.circlesgame.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.circlesgame.R
import com.example.circlesgame.databinding.ComponentCirclesBinding
import com.google.android.material.button.MaterialButton

private const val DEFAULT_COLOR = R.color.black

class CircleComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    private var _binding: ComponentCirclesBinding =
        ComponentCirclesBinding.inflate(LayoutInflater.from(context), this, true)

    private val _attributes =
        context.obtainStyledAttributes(attrs, R.styleable.ColorCircle)

    var startColor = _attributes.getColor(
        R.styleable.ColorCircle_color_corner,
        ContextCompat.getColor(context, DEFAULT_COLOR)
    )
    var startCountCircle = 20

    init {
        start()

    }

    private fun start() {
        var i = 0
        val randomCircle = (0..startCountCircle).random()
        while (i < startCountCircle) {
            if (i == randomCircle) _binding.parentLiner.addView(createStandardButton(startColor,0.9f))
            _binding.parentLiner.addView(createStandardButton())
            i++
        }
    }

    private fun createStandardButton(color: Int = startColor, newAlpha: Float = 1f): MaterialButton {
        return MaterialButton(context).apply {
            layoutParams = LayoutParams(100, 100)
            insetTop = 0
            insetBottom = 0
            alpha = newAlpha
            cornerRadius = 90
            setBackgroundColor(color)
            setOnClickListener { }
        }
    }

}