package com.acr.hexshop.api

import com.acr.hexshop.port.Supplier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shops/")
class ShopInventoryApi(val supplier: Supplier) {

    @PostMapping("{shopName}/{productName}/restock")
    fun restock(
        @PathVariable shopName: String,
        @PathVariable productName: String,
        @RequestParam quantity: Int,
    ) {
        supplier.supply(shopName, productName, quantity)
    }

}