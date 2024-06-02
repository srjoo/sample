package com.smwrd.sample.hilt.computer.asus

import com.smwrd.sample.hilt.computer.MotherBoard

abstract class AsusMotherBoard : MotherBoard {
    override fun getManufacturer(): String {
        return "Asus"
    }
}