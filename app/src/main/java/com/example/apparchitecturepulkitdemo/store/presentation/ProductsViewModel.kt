package com.example.apparchitecturepulkitdemo.store.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apparchitecturepulkitdemo.store.domain.respository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class ProductsViewModel(
    private val productsRepository: ProductRepository
): ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state: StateFlow<ProductViewState>
        get() = _state.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            _state.value = ProductViewState.LOADING

            productsRepository
                .getProducts()
                .onRight { result ->
                    _state.value = ProductViewState(
                        isLoading = false,
                        products = result,
                        error = null
                    )
                }
                .onLeft {
                    _state.value = ProductViewState(
                        isLoading = false,
                        products = emptyList(),
                        error = it.error.message
                    )
                }
        }

    }
}