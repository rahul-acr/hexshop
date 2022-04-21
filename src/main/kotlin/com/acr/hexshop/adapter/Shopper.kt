package com.acr.hexshop.adapter

import com.acr.hexshop.domain.Product
import com.acr.hexshop.port.Buyer
import com.acr.hexshop.port.ShopRepository
import org.springframework.stereotype.Component

@Component
class Shopper(private val repository: ShopRepository): Buyer {

    override fun buy(shopName: String, productName: String, quantity: Int) {
        val shop = repository.findShopByName(shopName)
        if(shop == null){
            throw IllegalArgumentException("shop $shopName does not exist")
        }
        shop.buy(productName, quantity)
    }

    override fun view(shopName: String): Collection<Product> {
        val shop = repository.findShopByName(shopName) ?: return emptySet()
        return shop.products
    }
}