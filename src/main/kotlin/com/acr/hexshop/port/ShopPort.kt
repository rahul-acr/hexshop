package com.acr.hexshop.port

import com.acr.hexshop.domain.Product
import com.acr.hexshop.domain.Shop

interface Viewer {

    fun view(shopName: String): Collection<Product>

}

interface Buyer : Viewer {

    fun buy(shopName: String, productName: String, quantity: Int)

}

interface Supplier {

    fun supply(shopName: String, productName: String, quantity: Int)

}

interface ShopRepository {

    fun findShopByName(shopName: String): Shop?

    fun add(shop: Shop)

}