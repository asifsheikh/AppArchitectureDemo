package com.example.apparchitecturepulkitdemo.store.data.repository

import arrow.core.Either
import com.example.apparchitecturepulkitdemo.store.data.mapper.toNetworkError
import com.example.apparchitecturepulkitdemo.store.domain.model.NetworkError
import com.example.apparchitecturepulkitdemo.store.domain.model.Product
import com.example.apparchitecturepulkitdemo.store.domain.respository.ProductRepository
import com.example.apparchitecturepulkitdemo.store.data.remote.ProductService
class ProductRepositoryImpl(
    private val productService: ProductService
) : ProductRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productService.getProducts()
        }.mapLeft { throwable ->
            throwable.toNetworkError()
        }
    }
}