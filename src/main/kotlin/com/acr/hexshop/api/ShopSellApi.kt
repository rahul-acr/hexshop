package com.acr.hexshop.api

import com.acr.hexshop.domain.Product
import com.acr.hexshop.port.Buyer
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shops/")
class ShopSellApi(val buyer: Buyer) {

    @GetMapping("{shopName}")
    fun view(@PathVariable shopName: String): Collection<Product> {
        return buyer.view(shopName)
    }

    @PostMapping("{shopName}/{productName}/buy")
    fun buy(
        @PathVariable shopName: String,
        @PathVariable productName: String,
        @RequestParam quantity: Int,
    ) {
        buyer.buy(shopName, productName, quantity)
    }


}