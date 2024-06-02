package com.smwrd.sample.hilt.computer.amd

import javax.inject.Inject

class R7_8700F @Inject constructor() : AMDCPU() {
    override fun getClockSpeed(): Double {
        return 4.2
    }

    override fun getName(): String {
        return "Ryzen™ 7 8700F"
    }

    override fun getPowerConsumption(): Int {
        return 65
    }
}