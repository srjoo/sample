package com.smwrd.sample.hilt.computer

interface MotherBoard : ComputerPart {
    fun getSupportArchitecture(): String
    fun getMaximumRam(): Int
}