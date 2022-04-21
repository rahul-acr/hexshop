package com.acr.hexshop.domain


class Shop(val name: String, products: List<Product>) {

    private val inventory = Inventory(products)

    val products = inventory.productMap.values

    fun buy(productName: String, quantity: Int) {
        val product = inventory.findProductByName(productName)
        inventory.unstock(product, quantity)
    }

    fun restock(productName: String, quantity: Int) {
        val product = inventory.findProductByName(productName)
        inventory.stock(product, quantity)
    }

}

class Inventory(products: List<Product>) {

    val productMap = products.associateBy { it.name }
    private val productStock: MutableMap<Product, Int> = HashMap()

    init {
        products.associateWithTo(productStock) { 0 }
    }

    fun findProductByName(productName: String): Product {
        return productMap[productName] ?: throw IllegalArgumentException()
    }

    fun unstock(product: Product, quantity: Int) {
        assertStockExists(product, quantity)
        productStock.computeIfPresent(product) { _, oldQuantity -> oldQuantity - quantity }
    }

    private fun assertStockExists(product: Product, quantity: Int) {
        val stock = productStock[product]
        if (stock != null && stock < quantity) {
            throw IllegalStateException("Not enough stock for $product")
        }
    }

    fun stock(product: Product, quantity: Int) {
        productStock.computeIfPresent(product) { _, oldQuantity -> oldQuantity + quantity }
    }


}

