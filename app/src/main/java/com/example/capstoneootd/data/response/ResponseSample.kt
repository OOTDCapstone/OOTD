package com.example.capstoneootd.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseSample(

	@field:SerializedName("image_urls_by_category")
	val imageUrlsByCategory: ImageUrlsByCategory? = null
)

data class ImageUrlsByCategory(

	@field:SerializedName("middle_row")
	val middleRow: List<MiddleRowItem?>? = emptyList(),

	@field:SerializedName("top_row")
	val topRow: List<TopRowItem?>? = emptyList(),

	@field:SerializedName("bottom_row")
	val bottomRow: List<BottomRowItem?>? = emptyList()
)

data class MiddleRowItem(

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("clothingType")
	val clothingType: String? = null
)

data class BottomRowItem(

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("clothingType")
	val clothingType: String? = null
)

@Parcelize
data class TopRowItem(

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("clothingType")
	val clothingType: String? = null
): Parcelable
