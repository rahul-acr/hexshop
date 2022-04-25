package com.acr.hexshop

import com.acr.hexshop.domain.Product
import com.acr.hexshop.domain.Shop
import com.acr.hexshop.repository.InMemoryShopRepository
import com.acr.hexshop.repository.ShopRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class HexshopApplication {

    @Bean
    fun testRepository(): ShopRepository {
        return InMemoryShopRepository().apply {
            add(Shop("goodshop",
                listOf(
                    Product("rice", 12.5),
                    Product("wheat", 32.0)
                )))
        }
    }
}


fun main(args: Array<String>) {
    runApplication<HexshopApplication>(*args)
}
