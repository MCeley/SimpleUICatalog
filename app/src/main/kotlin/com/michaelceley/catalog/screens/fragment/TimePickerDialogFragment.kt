package com.michaelceley.catalog.screens.fragment

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.michaelceley.catalog.util.Logger

class TimePickerDialogFragment : DialogFragment() {

    companion object {
        const val TAG = "TimePickerDialogFragment"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return TimePickerDialog(
            requireContext(),
            onTimeSetListener,
            5, 0, true
        )
    }

    private val onTimeSetListener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
        Logger.log("Time set: ($hourOfDay) hours and ($minute) minutes")
    }
}