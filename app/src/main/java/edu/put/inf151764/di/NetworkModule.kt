package edu.put.inf151764.di

import android.util.Xml
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.put.inf151764.data.api.GamesApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import kotlinx.serialization.*
import kotlinx.serialization.xml.*

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .connectTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(20,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
       return Retrofit
            .Builder()
            .baseUrl("https://boardgamegeek.com/xmlapi2/")
            .client(okHttpClient)
            .addConverterFactory(Xml)
            .build()
    }

    @Provides
    fun gamesApi(retrofit: Retrofit): GamesApi {
        return retrofit.create(GamesApi::class.java)
    }
}