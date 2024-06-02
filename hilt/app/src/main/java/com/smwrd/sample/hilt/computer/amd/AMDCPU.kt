package com.smwrd.sample.hilt.computer.amd

import com.smwrd.sample.hilt.computer.CPU

abstract class AMDCPU : CPU {
    override fun getArchitecture(): String {
        return "X64-AMD"
    }

    override fun getManufacturer(): String {
        return "AMD"
    }
}