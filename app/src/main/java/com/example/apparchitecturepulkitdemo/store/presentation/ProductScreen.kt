package com.example.apparchitecturepulkitdemo.store.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.apparchitecturepulkitdemo.store.presentation.utl.component.LoadingDialog
import com.example.apparchitecturepulkitdemo.store.presentation.utl.component.MyTopBar

@Composable
@ExperimentalMaterial3Api
fun ProductsScreen(
    viewModel: ProductsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductScreenContents(viewState = state)
}

@Composable
@ExperimentalMaterial3Api
fun ProductScreenContents(viewState: ProductViewState) {
    if (viewState.isLoading) {
        LoadingDialog()
    } else {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                MyTopBar(title = "Products")
            }
        ) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(top = it.calculateTopPadding()),
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalItemSpacing = 10.dp,
            ) {
                items(viewState.products) { product ->
                    ProductCard(product = product, onProductClick = {})
                }
            }
        }
    }
}

@Preview
@Composable
@ExperimentalMaterial3Api
fun PreviewProductScreenContents() {
    ProductScreenContents(ProductViewState.LOADING)
}
