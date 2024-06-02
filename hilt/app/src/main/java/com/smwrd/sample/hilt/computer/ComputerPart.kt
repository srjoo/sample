package com.smwrd.sample.hilt.computer

interface ComputerPart {
    fun getManufacturer() : String
    fun getName() : String
    fun getPowerConsumption() : Int
}