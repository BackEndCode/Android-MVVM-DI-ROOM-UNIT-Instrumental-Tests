package com.noministic.AndroidMvvmDiRoomUnitInstrumentalTests.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.noministic.AndroidMvvmDiRoomUnitInstrumentalTests.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ShoppingDaoTest {
    lateinit var shoppingItemsDatabase: ShoppingItemsDatabase
    lateinit var shoppingDao: ShoppingDao

    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()

    @Before
    fun setup() {
        shoppingItemsDatabase =
            Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                ShoppingItemsDatabase::class.java
            )
                .allowMainThreadQueries().build()
        shoppingDao = shoppingItemsDatabase.shoppingDao()
    }

    @Test
    fun testInsertShoppingItem() = runBlocking {
        val shoppingItem = ShoppingItem("anything", 34, "www.abc.com", 3,1)
        val result = shoppingDao.insertShoppingItem(shoppingItem)
        Assert.assertEquals(1, result)
    }
    @Test
    fun testDeleteShoppingItem() = runBlocking {
        val shoppingItem = ShoppingItem("anything", 34, "www.abc.com", 3,2)
        shoppingDao.insertShoppingItem(shoppingItem)
        val result = shoppingDao.deleteShoppingItem(shoppingItem)
        Assert.assertEquals(1, result)
    }
    @Test
    fun testObserveAllShoppingItems() = runBlocking {
        val shoppingItem = ShoppingItem("anything", 34, "www.abc.com", 3,2)
        shoppingDao.insertShoppingItem(shoppingItem)
        val result = shoppingDao.observeAllShoppingItems().getOrAwaitValue()
        Assert.assertEquals(1, result.size)
    }
    @Test
    fun testObserveTotalPrice() = runBlocking {
        val shoppingItem = ShoppingItem("anything", 50, "www.abc.com", 3,2)
        val shoppingItem1 = ShoppingItem("anything", 100, "www.abc.com", 3,3)
        shoppingDao.insertShoppingItem(shoppingItem)
        shoppingDao.insertShoppingItem(shoppingItem1)
        val result = shoppingDao.observeTotalPrice().getOrAwaitValue()
        Assert.assertEquals(450F, result)
    }
}