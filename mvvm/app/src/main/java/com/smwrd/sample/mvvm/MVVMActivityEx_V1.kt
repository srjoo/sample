package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvcExpandBinding
import com.smwrd.sample.mvvm.mvvm.OrderViewModelEx

class MVVMActivityEx_V1 : AppCompatActivity() {
    private lateinit var binding: ActivityMvcExpandBinding
    private lateinit var viewModel: OrderViewModelEx
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvcExpandBinding.inflate(layoutInflater)
        binding.titleText.text = "MVVM-EX_Observer"
        binding.exitButton.setOnClickListener {
            finish()
        }

        viewModel = OrderViewModelEx()

        binding.plusButton.setOnClickListener {
            viewModel.addCoffee()
        }
        binding.minusButton.setOnClickListener {
            viewModel.removeCoffee()
        }
        binding.waterPlusButton.setOnClickListener {
            viewModel.addWater()
        }
        binding.waterMinusButton.setOnClickListener {
            viewModel.removeWater()
        }
        binding.juicePlusButton.setOnClickListener {
            viewModel.addJuice()
        }
        binding.juiceMinusButton.setOnClickListener {
            viewModel.removeJuice()
        }

        viewModel.totalPrice.observe(this) {
            binding.sumNumberText.text = it
        }
        viewModel.coffeeQty.observe(this) {
            binding.numberText.text = it
        }
        viewModel.waterQty.observe(this) {
            binding.waterNumberText.text = it
        }
        viewModel.juiceQty.observe(this) {
            binding.juiceNumberText.text = it
        }

        setContentView(binding.root)
    }
}