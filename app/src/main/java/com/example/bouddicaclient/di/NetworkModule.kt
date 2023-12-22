package com.example.bouddicaclient.di

import com.example.bouddicaclient.data.datasource.remote.APIService
import com.example.bouddicaclient.data.datasource.remote.APIURL
import com.example.bouddicaclient.data.datasource.remote.createAPIService
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
    return APIURL.BASE_URL
  }

  @Provides
  @Singleton
  fun provideAPIService(): APIService {
    return createAPIService()
  }
}
