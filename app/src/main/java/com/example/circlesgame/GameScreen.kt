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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameScreenBinding.inflate(inflater, container, false)

        /*_binding?.gameCircles?.apply {
            callbackByChangeStandard = { correctAnswer() }
            startColor = R.color.purple_200
            changeAlpha = 0.5f
        }*/ // не работает
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
    }

    private fun correctAnswer() {
        score += 100
        binding.countScore.text = score.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}