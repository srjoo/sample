package com.smwrd.sample.hilt.module

import com.smwrd.sample.hilt.computer.CPU
import com.smwrd.sample.hilt.computer.Computer
import com.smwrd.sample.hilt.computer.ComputerImpl
import com.smwrd.sample.hilt.computer.MotherBoard
import com.smwrd.sample.hilt.computer.PowerSupply
import com.smwrd.sample.hilt.computer.Ram
import com.smwrd.sample.hilt.computer.amd.R7_8700F
import com.smwrd.sample.hilt.computer.asus.AS_A100
import com.smwrd.sample.hilt.computer.asus.AS_I100
import com.smwrd.sample.hilt.computer.intel.i9_13900
import com.smwrd.sample.hilt.computer.intel.i9_13900K
import com.smwrd.sample.hilt.computer.samsung.DDR5_16GB
import com.smwrd.sample.hilt.computer.samsung.DDR5_32GB
import com.smwrd.sample.hilt.computer.zalman.ZM_100
import com.smwrd.sample.hilt.computer.zalman.ZM_200
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
abstract class ComputerModule {
    companion object {
        @Provides
        @ActivityScoped
        @ComputerAll
        fun provideComputerAll(
            @Computer1 computer1: Computer,
            @Computer2 computer2: Computer,
            @Computer3 computer3: Computer,
            @Computer4 computer4: Computer,
        ) : List<Computer> = listOf(computer1, computer2, computer3, computer4,)

        @Provides
        @ActivityScoped
        @Computer1
        fun provideComputer1(
            @Computer1 cpu: CPU,
            @Computer1 ram: Ram,
            @Computer1 motherboard: MotherBoard,
            @Computer1 powerSupply: PowerSupply
        ) : Computer = ComputerImpl(cpu, ram, motherboard, powerSupply)

        @Provides
        @Computer2
        fun provideComputer2(
            @Computer2 cpu: CPU,
            @Computer2 ram: Ram,
            @Computer2 motherboard: MotherBoard,
            @Computer2 powerSupply: PowerSupply
        ) : Computer = ComputerImpl(cpu, ram, motherboard, powerSupply)

        @Provides
        @Computer3
        fun provideComputer3(
            @Computer3 cpu: CPU,
            @Computer3 ram: Ram,
            @Computer3 motherboard: MotherBoard,
            @Computer3 powerSupply: PowerSupply
        ) : Computer = ComputerImpl(cpu, ram, motherboard, powerSupply)

        @Provides
        @Computer4
        fun provideComputer4(
            @Computer4 cpu: CPU,
            @Computer4 ram: Ram,
            @Computer4 motherboard: MotherBoard,
            @Computer4 powerSupply: PowerSupply
        ) : Computer = ComputerImpl(cpu, ram, motherboard, powerSupply)
    }

    @Computer1
    @Binds
    abstract fun bindComputer1_CPU(cpu: i9_13900): CPU
    @Binds
    @Computer1
    abstract fun bindComputer1_Ram(ram: DDR5_16GB): Ram

    @Binds
    @Computer1
    abstract fun bindComputer1_Motherboard(ram: AS_I100): MotherBoard

    @Binds
    @Computer1
    abstract fun bindComputer1_PowerSupply(ram: ZM_100): PowerSupply

    @Binds
    @Computer2
    abstract fun bindComputer2_CPU(cpu: R7_8700F): CPU

    @Binds
    @Computer2
    abstract fun bindComputer2_Ram(ram: DDR5_32GB): Ram

    @Binds
    @Computer2
    abstract fun bindComputer2_Motherboard(ram: AS_A100): MotherBoard

    @Binds
    @Computer2
    abstract fun bindComputer2_PowerSupply(ram: ZM_200): PowerSupply

    @Binds
    @Computer3
    abstract fun bindComputer3_CPU(cpu: R7_8700F): CPU

    @Binds
    @Computer3
    abstract fun bindComputer3_Ram(ram: DDR5_16GB): Ram

    @Binds
    @Computer3
    abstract fun bindComputer3_Motherboard(ram: AS_I100): MotherBoard

    @Binds
    @Computer3
    abstract fun bindComputer3_PowerSupply(ram: ZM_200): PowerSupply

    @Binds
    @Computer4
    abstract fun bindComputer4_CPU(cpu: i9_13900K): CPU

    @Binds
    @Computer4
    abstract fun bindComputer4_Ram(ram: DDR5_32GB): Ram

    @Binds
    @Computer4
    abstract fun bindComputer4_Motherboard(ram: AS_I100): MotherBoard

    @Binds
    @Computer4
    abstract fun bindComputer4_PowerSupply(ram: ZM_100): PowerSupply
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ComputerAll

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Computer1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Computer2

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Computer3

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Computer4