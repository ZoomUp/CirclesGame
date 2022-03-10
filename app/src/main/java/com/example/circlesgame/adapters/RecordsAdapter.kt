package com.example.circlesgame.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.circlesgame.databinding.ItemRecordsAdapterBinding
import com.example.circlesgame.storages.SettingsStorage

class RecordsAdapter :
    RecyclerView.Adapter<RecordsAdapter.RecordsViewHolder>() {

    private var recordsList = SettingsStorage.listRecords.list

    inner class RecordsViewHolder(val binding: ItemRecordsAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        return RecordsViewHolder(
            ItemRecordsAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        holder.binding.record.text = recordsList[position].toString()
    }

    override fun getItemCount(): Int {
        return recordsList.size
    }

}