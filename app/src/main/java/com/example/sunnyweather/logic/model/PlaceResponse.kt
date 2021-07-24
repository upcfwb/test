package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 地点信息获取状态数据类
 *
 */
data class PlaceResponse(val status : String , val places : List<Place>)

/**
 * 地点数据类
 * @SerializedName 建立JSON和Kotlin映射关系，防止数据字段命名规范不同
 */
data class Place(val name : String ,val location : Location, @SerializedName("formatted_address") val address : String)

/**
 * 坐标数据类
 */
data class Location(val lat : String , val lng : String)
