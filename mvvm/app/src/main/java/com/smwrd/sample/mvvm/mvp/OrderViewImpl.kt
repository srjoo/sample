package com.smwrd.sample.mvvm.mvp

import android.widget.TextView

open class OrderViewImpl() : OrderView {
    lateinit var coffeeView:TextView
    lateinit var totalView:TextView

    override fun setTotalPrice(price: Int) {
        totalView.text = price.toString()
    }

    override fun setCoffeeQty(qty: Int) {
        coffeeView.text = qty.toString()
    }
}