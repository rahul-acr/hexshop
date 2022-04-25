package com.acr.hexshop.repository

import com.acr.hexshop.domain.Shop

interface ShopRepository {

    fun findShopByName(shopName: String): Shop?

    fun add(shop: Shop)

}