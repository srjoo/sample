package com.smwrd.sample.hilt.computer

interface CPU : ComputerPart {
    fun getArchitecture(): String
    fun getClockSpeed(): Double
}