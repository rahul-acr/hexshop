package com.acr.hexshop.adapter

import com.acr.hexshop.port.SupplyPort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shops/")
class ShopInventoryApi(val supplyPort: SupplyPort) {

    @PostMapping("{shopName}/{productName}/restock")
    fun restock(
        @PathVariable shopName: String,
        @PathVariable productName: String,
        @RequestParam quantity: Int,
    ) {
        supplyPort.supply(shopName, productName, quantity)
    }

}