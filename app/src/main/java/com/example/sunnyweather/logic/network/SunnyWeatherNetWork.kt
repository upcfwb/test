package com.example.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 统一网络数据源访问入口
 */
object SunnyWeatherNetWork {
    private val placeService = ServiceCreator.create<PlaceService>()
    private val weatherService = ServiceCreator.create<WeatherService>()

    suspend fun searchPlaces(query : String) = placeService.searchPlaces(query).await()


    suspend fun getDailyWeather(lng : String , lat : String) =
        weatherService.getDailyWeather(lng,lat).await()

    suspend fun getRealtimeWeather(lng : String ,lat : String) =
        weatherService.getRealtimeWeather(lng,lat).await()

    /**
     * 使用协程简化回调写法
     */
    private suspend fun <T> Call<T>.wait() : T {
        return suspendCoroutine { continuation ->
            enqueue( object  :Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if(body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}