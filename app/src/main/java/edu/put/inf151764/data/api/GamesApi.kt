package edu.put.inf151764.data.api

import edu.put.inf151764.data.api.data.ItemsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {
    @GET("collection")
    suspend fun getGames(
        @Query("username") username: String
    ): ItemsResponse
}