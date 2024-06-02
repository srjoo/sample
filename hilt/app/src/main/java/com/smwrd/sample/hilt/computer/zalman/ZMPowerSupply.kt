package com.smwrd.sample.hilt.computer.zalman

import com.smwrd.sample.hilt.computer.PowerSupply

abstract class ZMPowerSupply : PowerSupply {
    override fun getManufacturer(): String {
        return "ZALMAN"
    }

    override fun getPowerConsumption(): Int {
        return 0
    }
}