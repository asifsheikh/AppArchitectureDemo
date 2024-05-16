package com.example.apparchitecturepulkitdemo.store.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.apparchitecturepulkitdemo.store.domain.model.Product
import com.example.apparchitecturepulkitdemo.store.domain.model.Rating

@Composable
@ExperimentalMaterial3Api
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product, onProductClick: (Product) -> Unit
){
    Card (
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = { onProductClick(product) }
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            AsyncImage(
                model = product.imageUrl ,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = product.title,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL)
@Composable
@ExperimentalMaterial3Api
fun PreviewProductCard() {
    ProductCard(
        product = Product(
            id = 1,
            title = "Product Title this is just a demo",
            imageUrl = "https://picsum.photos/200/300",
            category = "Category",
            price = 100.0,
            description = "Description",
            rating = Rating(4.5, 1000)
        ),
        onProductClick = {}
    )
}

