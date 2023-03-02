package com.opdeveloper.opexpenseadmin.data.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.opdeveloper.opexpenseadmin.models.ProductosModel
import java.util.*
import java.util.Collections.emptyList




class ObjectConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<ProductosModel> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<ProductosModel>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<ProductosModel>): String {
        return gson.toJson(someObjects)
    }
}