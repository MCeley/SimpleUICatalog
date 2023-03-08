package com.michaelceley.catalog.screens

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import com.google.android.material.slider.Slider.OnChangeListener
import com.michaelceley.catalog.R
import com.michaelceley.catalog.util.Logger

class SliderControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider_controls)

        findViewById<SeekBar>(R.id.seekbar).setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    Logger.log("SeekBar progress changed: $progress")
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    Logger.log("SeekBar started tracking touches.")
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    Logger.log("SeekBar stopped tracking touches.")
                }
            }
        )

        findViewById<Slider>(R.id.slider).addOnChangeListener(
            OnChangeListener { _, value, _ -> Logger.log("Slider value changed: $value") }
        )

        findViewById<RangeSlider>(R.id.range_slider).addOnChangeListener(
            RangeSlider.OnChangeListener { _, value, _ -> Logger.log("Range Slider value changed: $value") }
        )
    }
}