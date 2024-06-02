package com.smwrd.sample.hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication : Application() {
    override fun toString(): String {
        return "${super.toString()} / [HiltApplication] 입니다~"
    }
}