package com.smwrd.sample.mvvm.mvp

import com.smwrd.sample.mvvm.model.Beverage
import com.smwrd.sample.mvvm.model.Juice
import com.smwrd.sample.mvvm.model.Water

class OrderPresenterExImpl(
    val viewEx:OrderViewEx,
    val waterModel: Water = Water(),
    val juiceModel: Juice = Juice()
    ) : OrderPresenterImpl(viewEx), OrderPresenterEx {
    override fun addWater() {
        addBeverage(waterModel)
    }

    override fun removeWater() {
        removeBeverage(waterModel)
    }

    override fun addJuice() {
        addBeverage(juiceModel)
    }

    override fun removeJuice() {
        removeBeverage(juiceModel)
    }

    override fun qtyViewUpdate(beverage: Beverage) {
        when(beverage) {
            waterModel -> viewEx.setWaterQty(beverage.quantity)
            juiceModel -> viewEx.setJuiceQty(beverage.quantity)
            else -> super.qtyViewUpdate(beverage)
        }
    }
}