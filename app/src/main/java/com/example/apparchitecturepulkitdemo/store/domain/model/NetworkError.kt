package com.example.apparchitecturepulkitdemo.store.domain.model

data class NetworkError(
    val error : ErrorType,
    val throwable: Throwable? = null
)
enum class ErrorType(val message: String) {
    NETWORK("Network error"),
    SERVER("Server error"),
    UNKNOWN("Unknown error")
}