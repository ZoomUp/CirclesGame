package com.example.circlesgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.circlesgame.databinding.FragmentMainScreenBinding
import com.example.circlesgame.storages.SettingsStorage
import kotlin.system.exitProcess

class MainScreen : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            MainScreen.background = SettingsStorage.mainBackgroundColor.toDrawable()
            buttonStart.apply {
                background = SettingsStorage.buttonColorD.toDrawable()
                setOnClickListener {
                    findNavController().navigate(R.id.action_MainScreen_to_GameScreen)
                }
            }
            buttonSettings.apply {
                background = SettingsStorage.buttonColorD.toDrawable()
                setOnClickListener {
                    findNavController().navigate(R.id.action_MainScreen_to_settingsScreen)
                }
            }
            buttonExit.apply {
                background = SettingsStorage.buttonColorD.toDrawable()
                setOnClickListener{
                    exitProcess(-1)
                }
            }
            buttonRecords.apply {
                background = SettingsStorage.buttonColorD.toDrawable()
                setOnClickListener{
                    findNavController().navigate(R.id.action_MainScreen_to_recordsScreen)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}