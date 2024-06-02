package com.smwrd.sample.hilt.computer.zalman

import javax.inject.Inject

class ZM_200 @Inject constructor() : ZMPowerSupply() {
    override fun getPower(): Int {
        return 200
    }

    override fun getName(): String {
        return "ZM-200"
    }
}