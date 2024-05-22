package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvvmV2Binding
import com.smwrd.sample.mvvm.mvvm.OrderViewModel

class MVVMActivity_V2 : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmV2Binding
    private lateinit var viewModel: OrderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvvmV2Binding.inflate(layoutInflater)
        binding.titleText.text = "MVVM_DataBinding"
        binding.exitButton.setOnClickListener {
            finish()
        }

        viewModel = OrderViewModel()
        binding.vm = viewModel
        binding.lifecycleOwner = this

        setContentView(binding.root)
    }
}