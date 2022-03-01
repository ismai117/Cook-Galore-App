package com.im.cookgaloreapp.data.local.converters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject


class Converter {

    val gson = Gson()

    @TypeConverter
    fun stringToList(value: String): List<String>{
        val listType: Type = object : TypeToken<List<String>>(){}.type
        return gson.fromJson<List<String>>(value, listType)
    }

    @TypeConverter
    fun listRoString(value: List<String>): String{
        return gson.toJson(value)
    }

}