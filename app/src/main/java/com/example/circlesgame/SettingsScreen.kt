package com.example.circlesgame

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.circlesgame.databinding.FragmentSettingsScreenBinding
import com.example.circlesgame.storages.SettingsStorage

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
        binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()

        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.action_settingsScreen_to_MainScreen)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initBackgroundColorButtons() {
        binding.buttonWhite.setOnClickListener {
            SettingsStorage.mainBackgroudColor = Color.WHITE
            binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()
        }

        binding.buttonGreen.setOnClickListener {
            SettingsStorage.mainBackgroudColor = Color.GREEN
            binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()
        }

        binding.buttonCyan.setOnClickListener {
            SettingsStorage.mainBackgroudColor = Color.CYAN
            binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()
        }

        binding.buttonYellow.setOnClickListener {
            SettingsStorage.mainBackgroudColor = Color.YELLOW
            binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()
        }

        binding.buttonGray.setOnClickListener {
            SettingsStorage.mainBackgroudColor = Color.GRAY
            binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()
        }

        binding.buttonMagenta.setOnClickListener {
            SettingsStorage.mainBackgroudColor = Color.MAGENTA
            binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()
        }
    }
}