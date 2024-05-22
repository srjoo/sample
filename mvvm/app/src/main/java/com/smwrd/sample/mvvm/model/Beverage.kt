package com.smwrd.sample.mvvm.model

open class Beverage(val price:Int) {
    var quantity:Int = 0

    open fun add() : Boolean {
        quantity++
        return true
    }

    open fun remove() : Boolean {
        if(quantity > 0) {
            quantity--
            return true
        } else {
            return false
        }
    }
}