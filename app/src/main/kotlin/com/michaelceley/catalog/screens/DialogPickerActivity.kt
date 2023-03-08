package com.michaelceley.catalog.screens

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.michaelceley.catalog.R
import com.michaelceley.catalog.screens.fragment.DatePickerDialogFragment
import com.michaelceley.catalog.screens.fragment.TimePickerDialogFragment
import com.michaelceley.catalog.util.Logger

class DialogPickerActivity : AppCompatActivity() {

    companion object {
        private val numbers = arrayOf(
            "Zero", "One", "Two", "Three"
        )

        private val teamArray = arrayOf(
            "Blue Jays" to "Toronto",
            "Orioles" to "Baltimore",
            "Rays" to "Tampa Bay",
            "Red Sox" to "Boston",
            "Yankees" to "New York"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)


        findViewById<Button>(R.id.button_alert_basic).setOnClickListener {
            android.app.AlertDialog.Builder(this@DialogPickerActivity)
                .setTitle("Testing Title")
                .setMessage("Some dialog message.")
                .setPositiveButton("OK") { _, _ ->
                    Logger.log("Positive button clicked.")
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

        findViewById<Button>(R.id.button_alert_list_basic).setOnClickListener {
            android.app.AlertDialog.Builder(this@DialogPickerActivity)
                .setTitle("Testing Title")
                .setItems(numbers) { _, which ->
                    Logger.log("List item clicked: ${numbers[which]}.")
                }
                .setNegativeButton("Close", null)
                .show()
        }

        findViewById<Button>(R.id.button_alert_list_custom).setOnClickListener {
            android.app.AlertDialog.Builder(this@DialogPickerActivity)
                .setTitle("Testing Title")
                .setAdapter(TeamAdapter(this@DialogPickerActivity, teamArray)) { _, which ->
                    Logger.log("List item clicked: ${teamArray[which]}.")
                }
                .show()
        }

        findViewById<Button>(R.id.button_alert_basic_x).setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(this@DialogPickerActivity)
                .setTitle("Testing Title")
                .setMessage("Some dialog message.")
                .setPositiveButton("OK") { _, _ ->
                    Logger.log("Positive button clicked.")
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

        findViewById<Button>(R.id.button_alert_list_basic_x).setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(this@DialogPickerActivity)
                .setTitle("Testing Title")
                .setItems(numbers) { _, which ->
                    Logger.log("List item clicked: ${numbers[which]}.")
                }
                .setNegativeButton("Close", null)
                .show()
        }

        findViewById<Button>(R.id.button_alert_list_custom_x).setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(this@DialogPickerActivity)
                .setTitle("Testing Title")
                .setAdapter(TeamAdapter(this@DialogPickerActivity, teamArray)) { _, which ->
                    Logger.log("List item clicked: ${teamArray[which]}.")
                }
                .show()
        }

        findViewById<Button>(R.id.button_date_basic).setOnClickListener {
            DatePickerDialog(
                this@DialogPickerActivity,
                onDateSetListener,
                2020, 3, 15
            ).show()
        }

        findViewById<Button>(R.id.button_date_fragment).setOnClickListener {
            DatePickerDialogFragment().show(supportFragmentManager, DatePickerDialogFragment.TAG)
        }

        findViewById<Button>(R.id.button_time_basic).setOnClickListener {
            TimePickerDialog(
                this@DialogPickerActivity,
                onTimeSetListener,
                5, 0, true
            ).show()
        }

        findViewById<Button>(R.id.button_time_fragment).setOnClickListener {
            TimePickerDialogFragment().show(supportFragmentManager, TimePickerDialogFragment.TAG)
        }
    }

    private val onDateSetListener = OnDateSetListener { _, year, month, dayOfMonth ->
        Logger.log("Date set: $month - $dayOfMonth - $year")
    }

    private val onTimeSetListener = OnTimeSetListener { _, hourOfDay, minute ->
        Logger.log("Time set: ($hourOfDay) hours and ($minute) minutes")
    }

    class TeamAdapter(context: Context, private val teams: Array<Pair<String, String>>) : BaseAdapter() {

        private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

        override fun getCount() = teams.size

        override fun getItem(position: Int): Pair<String, String> {
            return teams[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val team = getItem(position)

            return (convertView ?: layoutInflater.inflate(android.R.layout.simple_list_item_2, parent, false)).apply {
                findViewById<TextView>(android.R.id.text1).text = team.first
                findViewById<TextView>(android.R.id.text2).text = team.second
            }
        }
    }

}