package com.example.circlesgame

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.circlesgame.databinding.FragmentGameScreenBinding

class GameScreen : Fragment() {

    private var _binding: FragmentGameScreenBinding? = null
    private val binding get() = _binding!!
    private var score = 0
    private var changeAlphaCircle = 0.50f
    private val listColor = listOf(
        R.color.AliceBlue, R.color.AntiqueWhite, R.color.Aqua, R.color.Aquamarine,
        R.color.Azure, R.color.Beige, R.color.Bisque, R.color.Black, R.color.BlanchedAlmond,
        R.color.Blue, R.color.BlueViolet, R.color.Brown, R.color.BurlyWood, R.color.CadetBlue,
        R.color.Chartreuse, R.color.Chocolate, R.color.Coral, R.color.CornflowerBlue,
        R.color.DarkBlue, R.color.DarkCyan, R.color.DarkGoldenrod, R.color.DarkGray
    )
    private var startCount = 3
    private var counterTimer = 0
    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            countScore.text = score.toString()
            btnMenu.setOnClickListener {
                findNavController().navigate(R.id.action_GameScreen_to_MainScreen)
            }
        }
        createCircle()
        startTimeCounter()
    }

    private fun correctAnswer() {
        Toast.makeText(context, "Правильно!", Toast.LENGTH_SHORT).show()
        if (startCount < 80) startCount += 3
        changeAlphaCircle += 0.02f
        createCircle()
        score += 100
        counterTimer = 0
        timer.apply {
            cancel()
            start()
        }
        binding.countScore.text = score.toString()
    }

    private fun notCorrectAnswer() {
        Toast.makeText(context, "Не верно!", Toast.LENGTH_SHORT).show()
        startCount = 3
        changeAlphaCircle = 0.50f
        createCircle()
        score = 0
        binding.countScore.text = score.toString()
        counterTimer = 0
        timer.apply {
            cancel()
            start()
        }
    }

    private fun createCircle() {
        binding.gameCircles.apply {
            deleteAllCircle()
            callbackPositive = { correctAnswer() }
            callbackNegative = { notCorrectAnswer() }
            startCountCircle = startCount
            startColor = listColor.random()
            changeAlpha = changeAlphaCircle
            start()
        }
    }

    private fun startTimeCounter() {
        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = "Timer: $counterTimer"
                counterTimer++
            }

            override fun onFinish() {
                counterTimer = 0
                notCorrectAnswer()
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}