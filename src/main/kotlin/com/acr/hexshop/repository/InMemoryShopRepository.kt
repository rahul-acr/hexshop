package com.acr.hexshop.repository

import com.acr.hexshop.domain.Shop


class InMemoryShopRepository : ShopRepository {

    private val shops = HashMap<String, Shop>()

    override fun findShopByName(shopName: String): Shop? {
        return shops[shopName]
    }

    override fun add(shop: Shop) {
        if (shops[shop.name] != null) {
            throw IllegalStateException("Shop with name ${shop.name} already exists")
        }
        shops[shop.name] = shop
    }
}