package com.smwrd.sample.hilt.computer.asus

import javax.inject.Inject

class AS_I100 @Inject constructor() : AsusMotherBoard() {
    override fun getSupportArchitecture(): String {
        return "X64-Intel"
    }

    override fun getMaximumRam(): Int {
        return 32
    }

    override fun getName(): String {
        return "AS-I100"
    }

    override fun getPowerConsumption(): Int {
        return 20
    }
}