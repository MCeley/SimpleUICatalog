package com.michaelceley.catalog.screens.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.michaelceley.catalog.util.Logger

class DatePickerDialogFragment : DialogFragment() {

    companion object {
        const val TAG = "DatePickerDialogFragment"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return DatePickerDialog(
            requireContext(),
            onDateSetListener,
            2020, 3, 15
        )
    }

    private val onDateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        Logger.log("Date set: $month - $dayOfMonth - $year")
    }
}