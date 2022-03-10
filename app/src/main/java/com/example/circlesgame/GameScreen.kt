package com.example.circlesgame

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.circlesgame.databinding.FragmentGameScreenBinding
import com.example.circlesgame.storages.SettingsStorage
import com.example.circlesgame.storages.SettingsStorage.listRecords

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
    private var counterTimer = 11000L
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
            root.background = SettingsStorage.mainBackgroundColor.toDrawable()
            countScore.text = score.toString()
            btnMenu.setOnClickListener {
                listRecords.list.add(score)
                findNavController().navigate(R.id.action_GameScreen_to_MainScreen)
            }
        }
        createCircle()
        startTimeCounter()
    }

    private fun correctAnswer() {

        if (startCount < 80) startCount += 3
        changeAlphaCircle += 0.02f
        createCircle()
        score += 100
        timer.apply {
            cancel()
            start()
        }
        binding.countScore.text = score.toString()
    }

    private fun notCorrectAnswer() {
        ResultsDialogFragment(score).show(childFragmentManager, ResultsDialogFragment.TAG)
        startCount = 3
        changeAlphaCircle = 0.50f
        createCircle()
        listRecords.list.add(score)
        score = 0
        binding.countScore.text = score.toString()
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
        timer = object : CountDownTimer(counterTimer, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = "Timer: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                notCorrectAnswer()
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
        _binding = null
    }

}