package com.noministic.AndroidMvvmDiRoomUnitInstrumentalTests.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    var name:String,
    var price:Int,
    var imgURL:String,
    var amount:Int,
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
)
