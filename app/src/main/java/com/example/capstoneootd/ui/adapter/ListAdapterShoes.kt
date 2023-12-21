package com.example.capstoneootd.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneootd.data.response.BottomRowItem
import com.example.capstoneootd.databinding.OotdItemsBinding
import com.example.capstoneootd.ui.items.DetailItems


class ListAdapterShoes : ListAdapter<BottomRowItem, ListAdapterShoes.MyViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BottomRowItem>() {
            override fun areItemsTheSame(oldItem: BottomRowItem, newItem: BottomRowItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: BottomRowItem, newItem: BottomRowItem): Boolean {
                return oldItem == newItem
            }
        }
    }
    class MyViewHolder(val binding: OotdItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BottomRowItem) {
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterShoes.MyViewHolder {
        val binding = OotdItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListAdapterShoes.MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapterShoes.MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}