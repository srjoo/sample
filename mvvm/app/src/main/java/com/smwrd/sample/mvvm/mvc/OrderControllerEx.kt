package com.smwrd.sample.mvvm.mvc

import com.smwrd.sample.mvvm.model.Beverage
import com.smwrd.sample.mvvm.model.Juice
import com.smwrd.sample.mvvm.model.Water

class OrderControllerEx(val orderViewEx:OrderViewEx) : OrderController(orderViewEx) {
    val waterModel:Water = Water()
    val juiceModel:Juice = Juice()

    fun addWater() {
        addBeverage(waterModel)
    }

    fun removeWater() {
        removeBeverage(waterModel)
    }

    fun addJuice() {
        addBeverage(juiceModel)
    }

    fun removeJuice() {
        removeBeverage(juiceModel)
    }

    override fun beverageViewUpdate(beverage: Beverage) {
        when(beverage) {
            waterModel -> qtyViewUpdate(orderViewEx.waterView, beverage.quantity)
            juiceModel -> qtyViewUpdate(orderViewEx.juiceView, beverage.quantity)
            else -> super.beverageViewUpdate(beverage)
        }
    }
}