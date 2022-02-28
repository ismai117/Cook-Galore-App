package com.im.cookgaloreapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.im.cookgaloreapp.data.remote.service.RecipeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BASIC)

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

    }

    @Singleton
    @Provides
    fun provideRecipeNetwork(okHttpClient: OkHttpClient, gson: Gson): Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    }

    @Singleton
    @Provides
    fun provideRecipeService(retrofit: Retrofit): RecipeService{
        return retrofit.create(RecipeService::class.java)
    }

}