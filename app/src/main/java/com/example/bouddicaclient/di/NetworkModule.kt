package com.example.bouddicaclient.di

import com.example.bouddicaclient.data.datasource.remote.ApiURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Singleton
  @Provides
  fun provideBaseURL(): String {
    return ApiURL.SEARCH_URL
  }
}
