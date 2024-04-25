package com.example.apparchitecturepulkitdemo.store.domain.model

/**
 *     {
 *         "id": 1,
 *         "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
 *         "price": 109.95,
 *         "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
 *         "category": "men's clothing",
 *         "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
 *         "rating": {
 *             "rate": 3.9,
 *             "count": 120
 *         }
 *     },
 */
// create a data class called Product using the above json
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating,
)

data class Rating(
    val rate: Double,
    val count: Int,
)
