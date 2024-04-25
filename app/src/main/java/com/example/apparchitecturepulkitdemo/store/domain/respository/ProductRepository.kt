package com.example.apparchitecturepulkitdemo.store.domain.respository

import arrow.core.Either
import com.example.apparchitecturepulkitdemo.store.domain.model.NetworkError
import com.example.apparchitecturepulkitdemo.store.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): Either<NetworkError, List<Product>>
}