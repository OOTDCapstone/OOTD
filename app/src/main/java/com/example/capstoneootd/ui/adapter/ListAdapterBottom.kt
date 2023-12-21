package com.example.capstoneootd.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneootd.data.response.MiddleRowItem
import com.example.capstoneootd.data.response.TopRowItem
import com.example.capstoneootd.databinding.OotdItemsBinding
import com.example.capstoneootd.ui.items.DetailItems


class ListAdapterBottom : ListAdapter<MiddleRowItem, ListAdapterBottom.MyViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MiddleRowItem>() {
            override fun areItemsTheSame(oldItem: MiddleRowItem, newItem: MiddleRowItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: MiddleRowItem, newItem: MiddleRowItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(val binding: OotdItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MiddleRowItem) {
            binding.tvNameItems.text = item.clothingType
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .into(binding.ivData)

            binding.userItem.setOnClickListener {
                val intent = Intent(itemView.context, DetailItems::class.java)
                intent.putExtra(DetailItems.ITEMS, item.clothingType)
                itemView.context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterBottom.MyViewHolder {
        val binding = OotdItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListAdapterBottom.MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapterBottom.MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

}


