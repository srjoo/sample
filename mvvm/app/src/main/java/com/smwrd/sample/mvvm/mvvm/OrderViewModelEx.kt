package com.smwrd.sample.mvvm.mvvm

import androidx.lifecycle.MutableLiveData
import com.smwrd.sample.mvvm.model.Beverage
import com.smwrd.sample.mvvm.model.Juice
import com.smwrd.sample.mvvm.model.Water

open class OrderViewModelEx : OrderViewModel() {
    val waterQty: MutableLiveData<String> = MutableLiveData("0")
    val juiceQty: MutableLiveData<String> = MutableLiveData("0")
    val waterModel = Water()
    val juiceModel = Juice()

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

    override fun qtyUpdate(beverage: Beverage) {
        when(beverage) {
            waterModel -> waterQty.value = beverage.quantity.toString()
            juiceModel -> juiceQty.value = beverage.quantity.toString()
            else -> super.qtyUpdate(beverage)
        }
    }
}