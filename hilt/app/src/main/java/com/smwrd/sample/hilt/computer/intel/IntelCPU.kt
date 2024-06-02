package com.smwrd.sample.hilt.computer.intel

import com.smwrd.sample.hilt.computer.CPU

abstract class IntelCPU : CPU {
    override fun getArchitecture(): String {
        return "X64-Intel"
    }

    override fun getManufacturer(): String {
        return "Intel"
    }
}