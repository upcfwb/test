package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 网络库配置单例类
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyun.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> create(serviceClass: Class<T>) : T = retrofit.create(serviceClass)
    //泛型实化
    inline fun <reified T> create() : T = create(T :: class.java)

}