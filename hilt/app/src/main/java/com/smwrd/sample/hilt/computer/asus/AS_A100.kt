package com.smwrd.sample.hilt.computer.asus

import javax.inject.Inject

class AS_A100 @Inject constructor() : AsusMotherBoard() {
    override fun getSupportArchitecture(): String {
        return "X64-AMD"
    }

    override fun getMaximumRam(): Int {
        return 16
    }

    override fun getName(): String {
        return "AS-A100"
    }

    override fun getPowerConsumption(): Int {
        return 10
    }
}