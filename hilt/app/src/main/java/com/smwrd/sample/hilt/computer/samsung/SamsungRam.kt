package com.smwrd.sample.hilt.computer.samsung

import com.smwrd.sample.hilt.computer.Ram

abstract class SamsungRam : Ram {
    override fun getManufacturer(): String {
        return "Samsung"
    }
}