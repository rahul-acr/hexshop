package com.acr.hexshop.port

import com.acr.hexshop.repository.ShopRepository
import org.springframework.stereotype.Component

@Component
class SupplyPortImpl(val shopRepository: ShopRepository): SupplyPort {

    override fun supply(shopName: String, productName: String, quantity: Int) {
        shopRepository.findShopByName(shopName)?.restock(productName, quantity)
    }
}