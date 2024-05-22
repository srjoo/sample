package com.smwrd.sample.mvvm.mvvm

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smwrd.sample.mvvm.model.Beverage
import com.smwrd.sample.mvvm.model.Coffee
import com.smwrd.sample.mvvm.model.TotalPrice

open class OrderViewModel : ViewModel() {
    val coffeeQty: MutableLiveData<String> = MutableLiveData("0")
    val totalPrice: MutableLiveData<String> = MutableLiveData("0")
    val coffeeModel = Coffee()
    val totalModel = TotalPrice()

    fun addCoffee() {
        addBeverage(coffeeModel)
    }

    fun removeCoffee() {
        removeBeverage(coffeeModel)
    }

    fun addBeverage(beverage: Beverage) {
        if(beverage.add()) {
            qtyUpdate(beverage)
            increaseTotal(beverage.price)
        }
    }

    fun removeBeverage(beverage: Beverage) {
        if(beverage.remove()) {
            qtyUpdate(beverage)
            decreaseTotal(beverage.price)
        }
    }

    protected open fun qtyUpdate(beverage: Beverage) {
        coffeeQty.value = coffeeModel.quantity.toString()
    }

    protected fun increaseTotal(price: Int) {
        totalModel.increaseTotalPrice(price)
        updateTotal()
    }

    protected fun decreaseTotal(price: Int) {
        totalModel.decreaseTotalPrice(price)
        updateTotal()
    }

    protected fun updateTotal() {
        totalPrice.value = totalModel.totalPrice.toString()
    }
}