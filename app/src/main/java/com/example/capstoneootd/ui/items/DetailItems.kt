package com.example.capstoneootd.ui.items

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import com.bumptech.glide.Glide
import com.example.capstoneootd.R
import com.example.capstoneootd.data.response.TopRowItem
import com.example.capstoneootd.databinding.ActivityDetailItemsBinding
import com.example.capstoneootd.ui.home.HomeActivity

class DetailItems : AppCompatActivity() {

    companion object{
        const val ITEM_IMAGE_URL = "itemImageUrl"
        const val ITEM_CLOTHING_TYPE = "itemClothingType"
    }

    private lateinit var binding: ActivityDetailItemsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra(ITEM_IMAGE_URL)
        val clothingType = intent.getStringExtra(ITEM_CLOTHING_TYPE)

        if (imageUrl != null) {
            Glide.with(this)
                .load(imageUrl)
                .into(binding.imDetailphoto)
            binding.tvCategory.text = clothingType
        }


        binding.ivBack.setOnClickListener {
            startActivity(
                Intent(this@DetailItems, HomeActivity::class.java)
            )
        }
        binding.deleteItems.setOnClickListener {
            showPopup()
        }
    }
    private fun showPopup() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_popup_delete_items)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Use findViewById on the dialog's view
        val btnDelete: Button = dialog.findViewById(R.id.btnDelete)
        val btnCancel: Button = dialog.findViewById(R.id.btnCancel)

        val window = dialog.window
        val layoutParams = window?.attributes
        layoutParams?.width = ViewGroup.LayoutParams.MATCH_PARENT
        window?.attributes = layoutParams

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        btnDelete.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }


}