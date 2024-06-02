package com.smwrd.sample.hilt.computer.intel

import javax.inject.Inject

class i9_13900 @Inject constructor() : IntelCPU() {
    override fun getClockSpeed(): Double {
        return 5.2
    }

    override fun getName(): String {
        return "i9-13900"
    }

    override fun getPowerConsumption(): Int {
        return 65
    }
}