package com.deliveryhero.godroid.tech.exam.network.di

import android.app.Application
import com.appham.mockinizer.mockinize
import com.deliveryhero.godroid.tech.exam.network.ApiEndpoints
import com.deliveryhero.godroid.tech.exam.network.MockServer
import com.deliveryhero.godroid.tech.exam.network.OrdersCoroutinesApi
import com.deliveryhero.godroid.tech.exam.network.OrdersRxApi
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(mockServer: MockServer): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .mockinize(mockServer.getMocks())
            .build()

    @Provides
    @Singleton
    fun provideOrdersRxApi(okHttpClient: OkHttpClient): OrdersRxApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApiEndpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(OrdersRxApi::class.java)

    @Provides
    @Singleton
    fun provideOrdersCoroutinesApi(okHttpClient: OkHttpClient): OrdersCoroutinesApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApiEndpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OrdersCoroutinesApi::class.java)

    @Provides
    @Singleton
    fun provideMockServer(context: Application): MockServer = MockServer(context)
}
