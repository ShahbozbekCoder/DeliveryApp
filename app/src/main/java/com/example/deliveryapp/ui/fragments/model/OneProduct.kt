package com.example.deliveryapp.ui.fragments.model

import java.io.Serializable

data class OneProduct(
    var image: Int,
    var name: String,
    var price: String
): Serializable
