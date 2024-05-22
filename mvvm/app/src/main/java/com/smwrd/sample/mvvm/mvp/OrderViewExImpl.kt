package com.smwrd.sample.mvvm.mvp

import android.widget.TextView

class OrderViewExImpl : OrderViewImpl(), OrderViewEx {
    lateinit var waterView: TextView
    lateinit var juiceView: TextView
    override fun setWaterQty(qty: Int) {
        waterView.text = qty.toString()
    }

    override fun setJuiceQty(qty: Int) {
        juiceView.text = qty.toString()
    }
}