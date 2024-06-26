package com.smwrd.sample.mvvm.model

class TotalPrice {
    var totalPrice:Int = 0

    fun increaseTotalPrice(price: Int) {
        totalPrice += price
    }

    fun decreaseTotalPrice(price: Int) {
        totalPrice -= price
        if (totalPrice < 0) {
            totalPrice = 0
        }
    }
}