package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvcBinding
import com.smwrd.sample.mvvm.mvp.OrderPresenter
import com.smwrd.sample.mvvm.mvp.OrderPresenterImpl
import com.smwrd.sample.mvvm.mvp.OrderViewImpl

class MVPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvcBinding
    private lateinit var orderPresenter: OrderPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvcBinding.inflate(layoutInflater)
        binding.titleText.text = "MVP"
        binding.exitButton.setOnClickListener {
            finish()
        }

        val orderView = OrderViewImpl()
        orderView.totalView = binding.sumNumberText
        orderView.coffeeView = binding.numberText

        orderPresenter = OrderPresenterImpl(orderView)
        binding.plusButton.setOnClickListener {
            orderPresenter.addCoffee()
        }
        binding.minusButton.setOnClickListener {
            orderPresenter.removeCoffee()
        }

        setContentView(binding.root)
    }
}