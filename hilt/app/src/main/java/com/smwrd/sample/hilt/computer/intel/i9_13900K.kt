package com.smwrd.sample.hilt.computer.intel

import javax.inject.Inject

class i9_13900K @Inject constructor() : IntelCPU() {
    override fun getClockSpeed(): Double {
        return 5.4
    }

    override fun getName(): String {
        return "i9-13900K"
    }

    override fun getPowerConsumption(): Int {
        return 125
    }
}