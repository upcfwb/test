package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.media.session.MediaSession

/**
 * 自定义Application，方便获取Context
 */
class SunnyWeatherApplication : Application() {
    companion object{
        const val TOKEN = "" //网络API令牌
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}