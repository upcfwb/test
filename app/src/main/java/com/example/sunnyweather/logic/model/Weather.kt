package com.example.sunnyweather.logic.model

/**
 *天气数据类
 */
data class Weather(val realtime : RealtimeResponse.Realtime ,val daily : DailyResponse.Daily)
