package com.michaelceley.catalog.screens

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.michaelceley.catalog.R
import com.michaelceley.catalog.util.Logger

class BasicClicksActivity : AppCompatActivity() {

    // Clickable span to be used with R.id.text_span.
    private val clickableSpan = object : ClickableSpan() {
        override fun onClick(view: View) {
            Logger.log("ClickableSpan inside of TextView clicked.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_clicks)

        // Setup Button click listener.
        findViewById<Button>(R.id.button_simple).setOnClickListener {
            Logger.log("Simple Button clicked.")
        }

        // Setup TextView click listener.
        findViewById<TextView>(R.id.text_simple).setOnClickListener {
            Logger.log("Simple TextView clicked.")
        }

        // Setup TextView clickable span.
        findViewById<TextView>(R.id.text_span).apply {
            text = SpannableString(getString(R.string.span_text_click)).apply {
                setSpan(clickableSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            movementMethod = LinkMovementMethod.getInstance()
        }

        // Setup ImageButton click listener.
        findViewById<ImageButton>(R.id.image_button_email).setOnClickListener {
            Logger.log("Email ImageButton clicked.")
        }

        // Setup ImageView click listener.
        findViewById<ImageView>(R.id.image_email).setOnClickListener {
            Logger.log("Email ImageView clicked.")
        }

        // Setup FAB click listener.
        findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener {
            Logger.log("FloatingActionButton with add icon clicked.")
        }
    }
}