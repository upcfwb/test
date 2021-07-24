package com.example.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.Place
import com.google.gson.Gson

/**
 *记录地点单例类
 */
object PlaceDao {
    fun savePlace(place :Place){
        sharedPreference().edit{

        }
    }
    fun getSavedPlace() : Place{
        val placeJson = sharedPreference().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    fun isPlaceSaved() = sharedPreference().contains("place")

    private fun sharedPreference() = SunnyWeatherApplication.context
        .getSharedPreferences("sunny_weather",Context.MODE_PRIVATE)

}