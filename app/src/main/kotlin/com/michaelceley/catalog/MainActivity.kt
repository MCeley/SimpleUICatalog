package com.michaelceley.catalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michaelceley.catalog.screens.AdapterViewActivity
import com.michaelceley.catalog.screens.BasicClicksActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val screens = listOf<Pair<String, Class<*>>>(
            "Basic Clickable Views" to BasicClicksActivity::class.java,
            "Adapter Views" to AdapterViewActivity::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_catalog).apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
            adapter = CatalogItemAdapter()
        }
    }

    inner class CatalogItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        var screenPair: Pair<String, Class<*>>? = null

        fun setScreen(screen: Pair<String, Class<*>>) {
            screenPair = screen
            (itemView as? TextView)?.text = screen.first
        }

        override fun onClick(v: View?) {
            screenPair?.let {
                startActivity(Intent(this@MainActivity, it.second))
            }
        }
    }

    inner class CatalogItemAdapter : RecyclerView.Adapter<CatalogItemViewHolder>() {

        private var inflater = LayoutInflater.from(this@MainActivity)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder {
            return CatalogItemViewHolder(
                inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            )
        }

        override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
            holder.setScreen(screens[position])
        }

        override fun getItemCount(): Int = screens.size
    }
}