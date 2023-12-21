package com.example.capstoneootd.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneootd.data.dummydata.Topdummy
import com.example.capstoneootd.data.response.ImageUrlsByCategory
import com.example.capstoneootd.data.response.TopRowItem
import com.example.capstoneootd.databinding.OotdItemsBinding
import com.example.capstoneootd.ui.items.DetailItems

class ListAdapterTop : ListAdapter<TopRowItem, ListAdapterTop.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TopRowItem>() {
            override fun areItemsTheSame(oldItem: TopRowItem, newItem: TopRowItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem:TopRowItem, newItem: TopRowItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(val binding: OotdItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TopRowItem) {
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .into(binding.ivData)
            binding.tvNameItems.text = item.clothingType

            binding.userItem.setOnClickListener {
                val intent = Intent(itemView.context, DetailItems::class.java)
                intent.putExtra(DetailItems.ITEM_IMAGE_URL, item.imageUrl)
                intent.putExtra(DetailItems.ITEM_CLOTHING_TYPE, item.clothingType)
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = OotdItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}
