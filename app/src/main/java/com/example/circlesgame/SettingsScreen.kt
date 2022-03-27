package com.example.circlesgame

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.circlesgame.databinding.FragmentSettingsScreenBinding
import com.example.circlesgame.storages.SettingsStorage
import kotlin.random.Random

class SettingsScreen : Fragment() {

    private var _binding: FragmentSettingsScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSettingsScreenBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBackgroundColorButtons()
        binding.root.background = SettingsStorage.mainBackgroundColor.toDrawable()

        binding.btnMenu.apply {
            background = SettingsStorage.buttonColorD.toDrawable()
            setOnClickListener {
                with(activity?.getPreferences(Context.MODE_PRIVATE)?.edit()) {
                    this?.putInt("BACKGROUND_COLOR", SettingsStorage.mainBackgroundColor)
                    this?.putInt("BUTTON_COlOR", SettingsStorage.buttonColorD)
                    this?.apply()
                }
                findNavController().navigate(R.id.action_settingsScreen_to_MainScreen)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initBackgroundColorButtons() {
        binding.buttonWhite.setOnClickListener {
            SettingsStorage.mainBackgroundColor = Color.WHITE
            SettingsStorage.buttonColorD = Color.WHITE
            binding.btnMenu.background = SettingsStorage.buttonColorD.toDrawable()
            binding.root.background = SettingsStorage.mainBackgroundColor.toDrawable()
        }

        binding.buttonGreen.setOnClickListener {
            SettingsStorage.mainBackgroundColor = ContextCompat.getColor(requireContext(), R.color.green_bg)
            SettingsStorage.buttonColorD = ContextCompat.getColor(requireContext(), R.color.green_button)
            binding.btnMenu.background = SettingsStorage.buttonColorD.toDrawable()
            binding.root.background = SettingsStorage.mainBackgroundColor.toDrawable()
        }

        binding.buttonBlue.setOnClickListener {
            SettingsStorage.mainBackgroundColor = ContextCompat.getColor(requireContext(), R.color.blue_bg)
            SettingsStorage.buttonColorD = ContextCompat.getColor(requireContext(), R.color.blue_button)
            binding.btnMenu.background = SettingsStorage.buttonColorD.toDrawable()
            binding.root.background = SettingsStorage.mainBackgroundColor.toDrawable()
        }

        binding.buttonYellow.setOnClickListener {
            SettingsStorage.mainBackgroundColor = ContextCompat.getColor(requireContext(), R.color.yellow_bg)
            SettingsStorage.buttonColorD = ContextCompat.getColor(requireContext(), R.color.yellow_button)
            binding.btnMenu.background = SettingsStorage.buttonColorD.toDrawable()
            binding.root.background = SettingsStorage.mainBackgroundColor.toDrawable()
        }

        binding.buttonGray.setOnClickListener {
            SettingsStorage.mainBackgroundColor = ContextCompat.getColor(requireContext(), R.color.gray_bg)
            SettingsStorage.buttonColorD = ContextCompat.getColor(requireContext(), R.color.gray_button)
            binding.btnMenu.background = SettingsStorage.buttonColorD.toDrawable()
            binding.root.background = SettingsStorage.mainBackgroundColor.toDrawable()
        }

        binding.buttonPink.setOnClickListener {
            SettingsStorage.mainBackgroundColor = ContextCompat.getColor(requireContext(), R.color.pink_bg)
            SettingsStorage.buttonColorD = ContextCompat.getColor(requireContext(), R.color.pink_button)
            binding.btnMenu.background = SettingsStorage.buttonColorD.toDrawable()
            binding.root.background = SettingsStorage.mainBackgroundColor.toDrawable()
        }
    }
}