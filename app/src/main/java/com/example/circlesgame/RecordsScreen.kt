package com.example.circlesgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.circlesgame.adapters.RecordsAdapter
import com.example.circlesgame.databinding.FragmentRecordsScreenBinding

class RecordsScreen : Fragment() {

    private var _binding: FragmentRecordsScreenBinding? = null
    private val binding get() = _binding!!
    private val recordsAdapter = RecordsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRecordsScreenBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnMenu.setOnClickListener {
                findNavController().navigate(R.id.action_recordsScreen_to_MainScreen)
            }
            recyclerRecords.apply {
                adapter = recordsAdapter
                itemAnimator = null

            }
        }
        recordsAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}