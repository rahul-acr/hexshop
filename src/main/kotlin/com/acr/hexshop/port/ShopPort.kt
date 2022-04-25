package com.acr.hexshop.port

import com.acr.hexshop.domain.Product

interface ViewPort {

    fun view(shopName: String): Collection<Product>

}

interface BuyPort : ViewPort {

    fun buy(shopName: String, productName: String, quantity: Int)

}

interface SupplyPort {

    fun supply(shopName: String, productName: String, quantity: Int)

}
