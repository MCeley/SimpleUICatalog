package com.michaelceley.catalog.screens

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.michaelceley.catalog.R
import com.michaelceley.catalog.util.Logger

class AdapterViewActivity : AppCompatActivity() {

    companion object {

        val names = listOf(
            "Alcides",
            "Andrew",
            "Brian",
            "Bryan",
            "Jack",
            "Jerry",
            "Michael"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_views)

        findViewById<Spinner>(R.id.spinner_names).apply {
            adapter = ArrayAdapter(
                this@AdapterViewActivity,
                android.R.layout.simple_dropdown_item_1line,
                names
            )
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Logger.log("OnItemSelectedListener: onItemSelected")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    Logger.log("OnItemSelectedListener: onNothingSelected")
                }
            }
        }

        findViewById<ListView>(R.id.list_names).apply {
            adapter = ArrayAdapter(
                this@AdapterViewActivity,
                android.R.layout.simple_dropdown_item_1line,
                names
            )
            onItemClickListener = AdapterView.OnItemClickListener { _, _, _, _ ->
                Logger.log("OnItemClickListener: onItemClicked")
            }
        }
    }
}