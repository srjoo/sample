package com.smwrd.sample.mvvm.mvp

import com.smwrd.sample.mvvm.model.Beverage
import com.smwrd.sample.mvvm.model.Coffee
import com.smwrd.sample.mvvm.model.TotalPrice

open class OrderPresenterImpl (
    val view: OrderView,
    val coffeeModel: Beverage = Coffee(),
    val totalModel: TotalPrice = TotalPrice()
) : OrderPresenter {

    override fun addCoffee() {
        addBeverage(coffeeModel)
    }

    override fun removeCoffee() {
        removeBeverage(coffeeModel)
    }

    fun addBeverage(beverage: Beverage) {
        if(beverage.add()) {
            qtyViewUpdate(beverage)
            increaseTotal(beverage)
        }
    }

    fun removeBeverage(beverage: Beverage) {
        if(beverage.remove()) {
            qtyViewUpdate(beverage)
            decreaseTotal(beverage)
        }
    }

    fun increaseTotal(beverage: Beverage) {
        totalModel.increaseTotalPrice(beverage.price)
        totalViewUpdate()
    }

    fun decreaseTotal(beverage: Beverage) {
        totalModel.decreaseTotalPrice(beverage.price)
        totalViewUpdate()
    }

    open fun qtyViewUpdate(beverage: Beverage) {
        view.setCoffeeQty(beverage.quantity)
    }

    fun totalViewUpdate() {
        view.setTotalPrice(totalModel.totalPrice)
    }
}