package com.smwrd.sample.hilt.computer.zalman

import javax.inject.Inject

class ZM_100 @Inject constructor() : ZMPowerSupply() {
    override fun getPower(): Int {
        return 100
    }

    override fun getName(): String {
        return "ZM-100"
    }
}