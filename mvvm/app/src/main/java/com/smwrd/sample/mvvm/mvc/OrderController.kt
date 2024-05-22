package com.smwrd.sample.mvvm.mvc

import android.widget.TextView
import com.smwrd.sample.mvvm.model.Beverage
import com.smwrd.sample.mvvm.model.Coffee
import com.smwrd.sample.mvvm.model.TotalPrice

open class OrderController(val orderView:OrderView) {
    val totalPriceModel = TotalPrice()
    val coffeeModel = Coffee()

    fun addCoffee() {
        addBeverage(coffeeModel)
    }

    fun removeCoffee() {
        removeBeverage(coffeeModel)
    }

    protected fun addBeverage(beverage: Beverage) {
        if(beverage.add()) {
            totalPriceModel.increaseTotalPrice(beverage.price)
            beverageQtyChanged(beverage)
        }
    }

    protected fun removeBeverage(beverage: Beverage) {
        if(beverage.remove()) {
            totalPriceModel.decreaseTotalPrice(beverage.price)
            beverageQtyChanged(beverage)
        }
    }

    protected fun beverageQtyChanged(beverage: Beverage) {
        beverageViewUpdate(beverage)
        totalViewUpdate()
    }

    protected open fun beverageViewUpdate(beverage: Beverage) {
        qtyViewUpdate(orderView.coffeeView, beverage.quantity)
    }

    protected fun qtyViewUpdate(textView:TextView, qty:Int) {
        textView.text = qty.toString()
    }

    protected fun totalViewUpdate() {
        orderView.totalView.text = totalPriceModel.totalPrice.toString()
    }
}