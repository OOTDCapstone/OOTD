//package com.example.capstoneootd.ui.adapter
//
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.capstoneootd.data.dummydata.Topdummy
//import com.example.capstoneootd.data.response.ImageUrlsByCategory
//import com.example.capstoneootd.databinding.OotdItemsBinding
//import com.example.capstoneootd.ui.items.DetailItems
//
//class ListAdapterTop : ListAdapter<ImageUrlsByCategory, ListAdapterTop.MyViewHolder>(DIFF_CALLBACK) {
//
//    companion object {
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ImageUrlsByCategory>() {
//            override fun areItemsTheSame(oldItem: ImageUrlsByCategory, newItem: ImageUrlsByCategory): Boolean {
//                return oldItem == newItem
//            }
//
//            override fun areContentsTheSame(oldItem: ImageUrlsByCategory, newItem: ImageUrlsByCategory): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//    class MyViewHolder(val binding: OotdItemsBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: ImageUrlsByCategory) {
//            binding.tvNameItems.text = item.name
//            Glide.with(itemView.context)
//                .load(item.photo)
//                .into(binding.ivData)
//
//            binding.userItem.setOnClickListener {
//                val intent = Intent(itemView.context, DetailItems::class.java)
//                intent.putExtra(DetailItems.ITEMS, item.name)
//                itemView.context.startActivity(intent)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val binding = OotdItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentItem = getItem(position)
//        holder.bind(currentItem)
//    }
//}
