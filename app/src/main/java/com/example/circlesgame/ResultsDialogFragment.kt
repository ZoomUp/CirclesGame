package com.example.circlesgame

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.circlesgame.databinding.FragmentNotificationBinding

class ResultsDialogFragment(var score: Int): DialogFragment() {

    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        super.onViewCreated(view, savedInstanceState)
        binding.btnOk.setOnClickListener {
            dismiss()
        }
    }
    companion object {
        const val TAG = "ResultsDialogFragment"
    }
}