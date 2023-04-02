package com.example.zodiacproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class ItemAdapter(private val context: Context, private val dataset: List<ZodiacSign>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.zodiac_item)
        val seeInfoButton: Button = view.findViewById(R.id.seeInfoButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }
    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  item.name

        holder.seeInfoButton.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("zodiac_name", item.name)
            i.putExtra("zodiac_description", item.description)
            i.putExtra("zodiac_symbol", item.symbol)
            i.putExtra("zodiac_month", item.month)
            i.putExtra("zodiac_horoscope", item.horoscope)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            context.startActivity(i)
        }
    }
}