package com.example.apparchitecturepulkitdemo.store.data.remote

import com.example.apparchitecturepulkitdemo.store.domain.model.Product
import retrofit2.http.GET
interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}