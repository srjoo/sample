package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvcExpandBinding
import com.smwrd.sample.mvvm.mvp.OrderPresenterEx
import com.smwrd.sample.mvvm.mvp.OrderPresenterExImpl
import com.smwrd.sample.mvvm.mvp.OrderViewExImpl

class MVPActivityEx : AppCompatActivity() {
    private lateinit var binding: ActivityMvcExpandBinding
    private lateinit var orderPresenter: OrderPresenterEx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvcExpandBinding.inflate(layoutInflater)
        binding.titleText.text = "MVP-EX"
        binding.exitButton.setOnClickListener {
            finish()
        }

        val orderView = OrderViewExImpl()
        orderView.totalView = binding.sumNumberText
        orderView.coffeeView = binding.numberText
        orderView.waterView = binding.waterNumberText
        orderView.juiceView = binding.juiceNumberText

        orderPresenter = OrderPresenterExImpl(orderView)
        binding.plusButton.setOnClickListener {
            orderPresenter.addCoffee()
        }
        binding.minusButton.setOnClickListener {
            orderPresenter.removeCoffee()
        }
        binding.waterPlusButton.setOnClickListener {
            orderPresenter.addWater()
        }
        binding.waterMinusButton.setOnClickListener {
            orderPresenter.removeWater()
        }
        binding.juicePlusButton.setOnClickListener {
            orderPresenter.addJuice()
        }
        binding.juiceMinusButton.setOnClickListener {
            orderPresenter.removeJuice()
        }

        setContentView(binding.root)
    }
}