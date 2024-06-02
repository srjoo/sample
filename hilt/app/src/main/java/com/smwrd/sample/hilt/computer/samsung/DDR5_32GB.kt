package com.smwrd.sample.hilt.computer.samsung

import javax.inject.Inject

class DDR5_32GB @Inject constructor() : SamsungRam() {
    override fun getMemorySize(): Int {
        return 32
    }

    override fun getName(): String {
        return "DDR5 32GB"
    }

    override fun getPowerConsumption(): Int {
        return 20
    }
}