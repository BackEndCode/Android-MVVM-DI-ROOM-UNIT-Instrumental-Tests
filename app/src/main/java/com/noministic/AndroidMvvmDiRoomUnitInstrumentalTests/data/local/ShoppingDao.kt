package com.noministic.AndroidMvvmDiRoomUnitInstrumentalTests.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem): Long

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem):Int

    @Query("Select * from shopping_items")
    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    @Query("select sum(price * amount) from shopping_items")
    fun observeTotalPrice(): LiveData<Float>
}