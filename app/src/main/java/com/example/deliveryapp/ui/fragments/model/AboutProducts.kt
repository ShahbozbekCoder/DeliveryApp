package com.example.deliveryapp.ui.fragments.model

import java.io.Serializable

data class AboutProducts(
    var product1: OneProduct?,
    var product2: OneProduct?,
    var product3: OneProduct?,
    var product4: OneProduct?,
    var product5: OneProduct?,
    var product6: OneProduct?,
    var product7: OneProduct?,
    var product8: OneProduct?,
    var product9: OneProduct?,
    var product10: OneProduct?,
    var product11: OneProduct?,
    var product12: OneProduct?,
): Serializable {
    constructor() : this(null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null)
}
