package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvcBinding
import com.smwrd.sample.mvvm.mvc.OrderController
import com.smwrd.sample.mvvm.mvc.OrderView

class MVCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvcBinding
    private lateinit var orderController: OrderController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvcBinding.inflate(layoutInflater)
        binding.exitButton.setOnClickListener {
            finish()
        }

        val orderView = OrderView()
        orderView.totalView = binding.sumNumberText
        orderView.coffeeView = binding.numberText

        orderController = OrderController(orderView)
        binding.plusButton.setOnClickListener {
            orderController.addCoffee()
        }
        binding.minusButton.setOnClickListener {
            orderController.removeCoffee()
        }

        setContentView(binding.root)
    }
}