package com.example.sunnyweather.logic.model

import androidx.work.Data
import com.google.gson.annotations.SerializedName

/**
 * 未来几天天气接口返回数据类
 */
data class DailyResponse(val status : String ,val result: Result){
    data class Result(val daily :Daily)
    data class Daily(val temperature : List<Temperature>,val skycon : Skycon,@SerializedName("life_index") val lifeIndex : LifeIndex)
    data class Temperature(val max : Float ,val min :Float)
    data class Skycon(val value : String ,val data : Data)
    data class LifeIndex(val coldRisk : List<LifeDescription>,val carWashing  : List<LifeDescription>,
                         val ultraviolet  : List<LifeDescription>,val dressing  : List<LifeDescription>)
    data class LifeDescription(val desc : String)
}
