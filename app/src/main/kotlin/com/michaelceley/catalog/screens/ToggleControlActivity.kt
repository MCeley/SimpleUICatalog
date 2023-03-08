package com.michaelceley.catalog.screens

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.michaelceley.catalog.R
import com.michaelceley.catalog.util.Logger

class ToggleControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_controls)

        findViewById<CheckBox>(R.id.checkbox).setOnCheckedChangeListener { _, checked ->
            Logger.log("Checkbox value changed to $checked.")
        }

        findViewById<ToggleButton>(R.id.toggle).setOnCheckedChangeListener { _, checked ->
            Logger.log("ToggleButton value changed to $checked.")
        }

        findViewById<SwitchCompat>(R.id.switch_compat).setOnCheckedChangeListener { _, checked ->
            Logger.log("SwitchCompat value changed to $checked.")
        }

        findViewById<RadioGroup>(R.id.radio_group).setOnCheckedChangeListener { radioGroup, id ->
            Logger.log("RadioGroup selected value changed to " +
                    "${if(id != -1) radioGroup.findViewById<RadioButton>(id).text else "nothing"}.")
        }
    }
}