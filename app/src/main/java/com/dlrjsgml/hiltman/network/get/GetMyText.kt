package com.dlrjsgml.hiltman.network.get

import com.dlrjsgml.hiltman.network.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GetMakeCommitMessagesService {
    @GET("/github/make/{username}")
    suspend fun getMakeCommitMessages(@Path("username") username: String,@Query("date") date: String): BaseResponse<String>
}