package com.example.bouddicaclient.data.datasource.remote

import com.example.bouddicaclient.data.model.BaseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
  @GET("movie/now_playing")
  suspend fun nowPlayingMovieList(
    @Query("page") page: Int,
    @Query("with_genres") genreId: String?,
    @Query("api_key") api_key: String = "key"
  ): BaseModel
}
