package com.smwrd.sample.hilt.computer

import javax.inject.Inject

class ComputerImpl @Inject constructor(
    private val cpu: CPU,
    private val ram: Ram,
    private val motherBoard: MotherBoard,
    private val powerSupply: PowerSupply
) : Computer {
    private val log:StringBuilder = StringBuilder()

    override fun turnOn() : Boolean {
        var success = true
        apppendLog("컴퓨터 부팅중")
        apppendLog(toString())
        if(!checkPower()) {
            apppendLog("파워가 부족합니다")
            success = false
        }
        if(!checkCPU()) {
            apppendLog("메인보드가 지원하지 않는 CPU 아키텍처입니다")
            success = false
        }
        if(!checkRam()) {
            apppendLog("메인보드가 지원하는 Ram 크기보다 큽니다")
            success = false
        }

        if(success) {
            apppendLog("컴퓨터 부팅 성공")
        } else {
            apppendLog("컴퓨터 부팅 실패")
        }

        return success
    }

    override fun getLog() : String {
        if(log.length > 0) {
            return log.toString()
        } else {
            return "${toString()}\n로그가 없습니다"
        }
    }

    override fun toString(): String {
        return """
            [컴퓨터 정보]
            |CPU : ${cpu.getManufacturer()} ${cpu.getName()}
            |RAM : ${ram.getManufacturer()} ${ram.getName()}
            |MotherBoard : ${motherBoard.getManufacturer()} ${motherBoard.getName()}
            |PowerSupply : ${powerSupply.getManufacturer()} ${powerSupply.getName()}
        """.trimIndent()
    }

    private fun apppendLog(msg:String) {
        log.append("${msg}\n")
    }

    private fun checkPower() : Boolean = availablePower() >= usePower()

    private fun availablePower() : Int = powerSupply.getPower()

    private fun usePower() : Int = cpu.getPowerConsumption() + ram.getPowerConsumption() + motherBoard.getPowerConsumption() + powerSupply.getPowerConsumption()

    private fun checkCPU() : Boolean = cpu.getArchitecture().equals(motherBoard.getSupportArchitecture())

    private fun checkRam(): Boolean = ram.getMemorySize() <= motherBoard.getMaximumRam()
}