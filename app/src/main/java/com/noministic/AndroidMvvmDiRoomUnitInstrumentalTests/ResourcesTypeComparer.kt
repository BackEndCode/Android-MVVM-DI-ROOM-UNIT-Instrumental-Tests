package com.noministic.AndroidMvvmDiRoomUnitInstrumentalTests

import android.content.Context
import android.util.Log

class ResourcesTypeComparer {

    fun isEqual(context: Context, resId:Int, compareString:String):Boolean{
        Log.e(context.getString(resId),compareString)
        return context.getString(resId) == compareString
    }
}