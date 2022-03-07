package com.example.circlesgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        R.color.Chartreuse, R.color.Chocolate, R.color.Coral, R.color.CornflowerBlue
    )
    private var startCount = 6

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
        createGameCircle()
    }

    private fun createGameCircle() {
        _binding?.gameCircles?.apply {
            callbackByChangeStandard = { correctAnswer() }
            callbackByStandard = { notCorrectAnswer() }
            startCountCircle = startCount
            startColor = listColor.random()
            changeAlpha = changeAlphaCircle
            start()
        }
    }

    private fun correctAnswer() {
        startCount += 2
        changeAlphaCircle += 0.05f
        _binding?.gameCircles?.apply {
            deleteAllCircle()
            callbackByChangeStandard = { correctAnswer() }
            callbackByStandard = { notCorrectAnswer() }
            startCountCircle = startCount
            startColor = listColor.random()
            changeAlpha = changeAlphaCircle
            start()
        }
        score += 100
        binding.countScore.text = score.toString()
    }

    private fun notCorrectAnswer() {
        startCount = 6
        changeAlphaCircle = 0.50f
        _binding?.gameCircles?.apply {
            deleteAllCircle()
            callbackByChangeStandard = { correctAnswer() }
            callbackByChangeStandard = { notCorrectAnswer() }
            startCountCircle = startCount
            startColor = listColor.random()
            changeAlpha = changeAlphaCircle
            start()
        }
        score = 0
        binding.countScore.text = score.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}