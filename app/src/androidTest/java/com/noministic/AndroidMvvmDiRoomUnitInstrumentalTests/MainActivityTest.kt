package com.noministic.AndroidMvvmDiRoomUnitInstrumentalTests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var resourcesTypeComparer: ResourcesTypeComparer

    @Before
    fun setup() {
        resourcesTypeComparer = ResourcesTypeComparer()
    }
    @Test
    fun testIsEqual() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result=resourcesTypeComparer.isEqual(context, R.string.app_name, "Unit_Testingg")
        assertEquals(false,result)
    }
}