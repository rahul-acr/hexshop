package com.acr.hexshop.adapter

import com.acr.hexshop.domain.Product
import com.acr.hexshop.port.BuyPort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shops/")
class ShopSellApi(val buyPort: BuyPort) {

    @GetMapping("{shopName}")
    fun view(@PathVariable shopName: String): Collection<Product> {
        return buyPort.view(shopName)
    }

    @PostMapping("{shopName}/{productName}/buy")
    fun buy(
        @PathVariable shopName: String,
        @PathVariable productName: String,
        @RequestParam quantity: Int,
    ) {
        buyPort.buy(shopName, productName, quantity)
    }


}