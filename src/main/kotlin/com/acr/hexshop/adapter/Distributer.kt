package com.acr.hexshop.adapter

import com.acr.hexshop.port.ShopRepository
import com.acr.hexshop.port.Supplier
import org.springframework.stereotype.Component

@Component
class Distributer(val shopRepository: ShopRepository): Supplier {

    override fun supply(shopName: String, productName: String, quantity: Int) {
        shopRepository.findShopByName(shopName)?.restock(productName, quantity)
    }
}