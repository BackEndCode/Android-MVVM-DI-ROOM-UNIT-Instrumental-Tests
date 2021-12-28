package com.noministic.AndroidMvvmDiRoomUnitInstrumentalTests

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun isEqual(context:Context,resId:Int,compareString:String):Boolean{
        Log.e(context.getString(resId),compareString)
        return context.getString(resId) == compareString
    }
}