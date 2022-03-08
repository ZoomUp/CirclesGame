package com.example.circlesgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.navigation.fragment.findNavController
import com.example.circlesgame.databinding.FragmentMainScreenBinding
import com.example.circlesgame.storages.SettingsStorage

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainScreen : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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
        binding.root.background = SettingsStorage.mainBackgroudColor.toDrawable()

        binding.buttonStart.setOnClickListener {
            findNavController().navigate(R.id.action_MainScreen_to_GameScreen)
        }
        binding.buttonSettings.setOnClickListener {
            findNavController().navigate(R.id.action_MainScreen_to_settingsScreen)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}