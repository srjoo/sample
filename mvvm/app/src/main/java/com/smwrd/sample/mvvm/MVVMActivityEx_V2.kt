package com.smwrd.sample.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smwrd.sample.mvvm.databinding.ActivityMvvmExpandV2Binding
import com.smwrd.sample.mvvm.mvvm.OrderViewModelEx

class MVVMActivityEx_V2 : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmExpandV2Binding
    private lateinit var viewModel: OrderViewModelEx
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvvmExpandV2Binding.inflate(layoutInflater)
        binding.titleText.text = "MVVM-EX_DataBinding"
        binding.exitButton.setOnClickListener {
            finish()
        }

        viewModel = OrderViewModelEx()
        binding.vm = viewModel
        binding.lifecycleOwner = this

        setContentView(binding.root)
    }
}