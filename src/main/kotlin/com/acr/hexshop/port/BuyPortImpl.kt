package com.acr.hexshop.port

import com.acr.hexshop.domain.Product
import com.acr.hexshop.repository.ShopRepository
import org.springframework.stereotype.Component

@Component
class BuyPortImpl(private val repository: ShopRepository): BuyPort {

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