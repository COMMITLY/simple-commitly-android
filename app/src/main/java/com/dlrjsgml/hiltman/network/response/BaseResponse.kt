package com.dlrjsgml.hiltman.network.response

data class BaseResponse<T> (

    val status: Int,
    val state: String? = "OK",
    val message: String,
    val data: T? = null
)