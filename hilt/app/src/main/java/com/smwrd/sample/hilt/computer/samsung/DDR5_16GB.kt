package com.smwrd.sample.hilt.computer.samsung

import javax.inject.Inject

class DDR5_16GB @Inject constructor() : SamsungRam() {
    override fun getMemorySize(): Int {
        return 16
    }

    override fun getName(): String {
        return "DDR5 16GB"
    }

    override fun getPowerConsumption(): Int {
        return 10
    }
}