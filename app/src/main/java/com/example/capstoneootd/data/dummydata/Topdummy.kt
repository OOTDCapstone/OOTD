package com.example.capstoneootd.data.dummydata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topdummy (
    var name: String,
    var id : Int,
    var photo: String
    ): Parcelable
object dummydata{

    fun getDummyData(): List<Topdummy>{
        return listOf<Topdummy>(
            Topdummy(name = "T-Shirt", id = 1, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),
            Topdummy(name = "T-Shirt", id = 2, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),
            Topdummy(name = "T-Shirt", id = 3, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),
            Topdummy(name = "T-Shirt", id = 4, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),
            Topdummy(name = "T-Shirt", id = 5, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),
            Topdummy(name = "T-Shirt", id = 6, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),
            Topdummy(name = "T-Shirt", id = 7, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),
            Topdummy(name = "T-Shirt", id = 8, photo = "https://zora.co.id/wp-content/uploads/2018/11/Kaos-pendek-belakang.png" ),

        )
    }

}