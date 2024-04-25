package com.example.apparchitecturepulkitdemo.store.data.mapper

import com.example.apparchitecturepulkitdemo.store.domain.model.NetworkError
import com.example.apparchitecturepulkitdemo.store.domain.model.ErrorType.SERVER
import com.example.apparchitecturepulkitdemo.store.domain.model.ErrorType.NETWORK
import com.example.apparchitecturepulkitdemo.store.domain.model.ErrorType.UNKNOWN
import retrofit2.HttpException
import java.io.IOException
fun Throwable.toNetworkError(): NetworkError {
    val error = when (this) {
        is java.net.UnknownHostException -> NETWORK
        is IOException -> NETWORK
        is HttpException -> SERVER
        else -> UNKNOWN
    }
    return NetworkError(
        error = error,
        throwable = this
    )
}