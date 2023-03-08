package com.michaelceley.catalog.screens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.michaelceley.catalog.R
import com.michaelceley.catalog.util.Logger

class EditFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_fields)

        findViewById<EditText>(R.id.edit_basic).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Logger.log("Edit Basic: beforeTextChanged")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Logger.log("Edit Basic: onTextChanged")
            }

            override fun afterTextChanged(s: Editable?) {
                Logger.log("Edit Basic: afterTextChanged")
            }
        })

        findViewById<EditText>(R.id.edit_name).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Logger.log("Edit Name: beforeTextChanged")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Logger.log("Edit Name: onTextChanged")
            }

            override fun afterTextChanged(s: Editable?) {
                Logger.log("Edit Name: afterTextChanged")
            }
        })
    }
}