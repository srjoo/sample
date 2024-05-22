package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvcBinding
import com.smwrd.sample.mvvm.mvvm.OrderViewModel

class MVVMActivity_V1 : AppCompatActivity() {
    private lateinit var binding: ActivityMvcBinding
    private lateinit var viewModel: OrderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvcBinding.inflate(layoutInflater)
        binding.titleText.text = "MVVM_Observer"
        binding.exitButton.setOnClickListener {
            finish()
        }

        viewModel = OrderViewModel()

        binding.plusButton.setOnClickListener {
            viewModel.addCoffee()
        }
        binding.minusButton.setOnClickListener {
            viewModel.removeCoffee()
        }

        viewModel.totalPrice.observe(this) {
            binding.sumNumberText.text = it
        }
        viewModel.coffeeQty.observe(this) {
            binding.numberText.text = it
        }

        setContentView(binding.root)
    }
}