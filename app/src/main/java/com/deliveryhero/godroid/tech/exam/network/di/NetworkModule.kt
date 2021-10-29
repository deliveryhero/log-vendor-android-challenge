package com.deliveryhero.godroid.tech.exam.network.di

import com.deliveryhero.godroid.tech.exam.network.Api
import com.deliveryhero.godroid.tech.exam.network.ApiEndpoints
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
        }.build()

    @Provides
    @Singleton
    fun provideProductsApi(okHttpClient: OkHttpClient): Api =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApiEndpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(Api::class.java)
}
