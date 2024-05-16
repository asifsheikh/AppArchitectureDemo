package com.example.apparchitecturepulkitdemo.store.presentation

import com.example.apparchitecturepulkitdemo.store.domain.model.Product

data class ProductViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null,
){
    companion object {
        val LOADING = ProductViewState(
            isLoading = true,
            products = emptyList(),
            error = null
        )
    }
}
