package com.example.tacianemartimiano.cklmvvm.utils.api

import com.example.tacianemartimiano.cklmvvm.utils.constants.JSON_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    var retrofit: Retrofit? = null
        get() = buildRetrofit()


    private fun buildRetrofit(): Retrofit? {
        val client = buildClient()
        return Retrofit.Builder()
                .baseUrl(JSON_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .client(client)
                .build()
    }

    private fun buildClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    private fun buildGson(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }
}