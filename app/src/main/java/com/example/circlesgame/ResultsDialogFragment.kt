package com.example.circlesgame

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment
import com.example.circlesgame.databinding.FragmentNotificationBinding
import com.example.circlesgame.storages.SettingsStorage

class ResultsDialogFragment(var score: Int, var notificationCallback: () -> Unit = {}): DialogFragment() {

    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        binding.txtMessage.text = score.toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        super.onViewCreated(view, savedInstanceState)
        binding.btnOk.apply {
            background = SettingsStorage.buttonColorD.toDrawable()
            setOnClickListener {
                notificationCallback.invoke()
                dismiss()
            }
        }
        binding.parentConstraint.background = SettingsStorage.buttonColorD.toDrawable()
    }
    companion object {
        const val TAG = "ResultsDialogFragment"
    }
}