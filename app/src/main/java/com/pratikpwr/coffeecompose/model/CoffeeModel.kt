package com.pratikpwr.coffeecompose.model

import kotlin.random.Random

class CoffeeModel(
    val id: Int,
    val name: String,
    val image: String,
    val price: Double = Random(10).nextDouble(0.0, 10.0),
    val items: List<String> = mutableListOf(),
    val description: String = ""
)


class CoffeeInCart(val coffee: CoffeeModel, val quantity: Int)