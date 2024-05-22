package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvcExpandBinding
import com.smwrd.sample.mvvm.mvc.OrderControllerEx
import com.smwrd.sample.mvvm.mvc.OrderViewEx

class MVCActivityEx : AppCompatActivity() {
    private lateinit var binding: ActivityMvcExpandBinding
    private lateinit var orderController: OrderControllerEx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvcExpandBinding.inflate(layoutInflater)
        binding.titleText.text = "MVC-EX"
        binding.exitButton.setOnClickListener {
            finish()
        }

        val orderView = OrderViewEx()
        orderView.totalView = binding.sumNumberText
        orderView.coffeeView = binding.numberText
        orderView.waterView = binding.waterNumberText
        orderView.juiceView = binding.juiceNumberText

        orderController = OrderControllerEx(orderView)
        binding.plusButton.setOnClickListener {
            orderController.addCoffee()
        }
        binding.minusButton.setOnClickListener {
            orderController.removeCoffee()
        }
        binding.waterPlusButton.setOnClickListener {
            orderController.addWater()
        }
        binding.waterMinusButton.setOnClickListener {
            orderController.removeWater()
        }
        binding.juicePlusButton.setOnClickListener {
            orderController.addJuice()
        }
        binding.juiceMinusButton.setOnClickListener {
            orderController.removeJuice()
        }

        setContentView(binding.root)
    }
}