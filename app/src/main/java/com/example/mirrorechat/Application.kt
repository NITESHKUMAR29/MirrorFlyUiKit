package com.example.mirrorechat

import android.app.Application
import android.util.Log

import com.contus.flycommons.LogMessage


import com.contusflysdk.ChatSDK
import com.mirrorflyuikitsdk.MirrorFlyUIKit
import com.mirrorflyuikitsdk.adapter.MirrorFlyUIKitAdapter
import com.mirrorflyuikitsdk.interfaces.InitResultHandler

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        MirrorFlyUIKit.initFlySDK(applicationContext,object : MirrorFlyUIKitAdapter {

            override fun setAppName(): String {
                return "Chat"
            }
            override fun setBaseUrl(): String {
                return "https://api-preprod-sandbox.mirrorfly.com"
            }
            override fun setLicence(): String {
                return "CfIstf8qENtH1M15GKrJxsBp867Zza"
            }
            override fun isCallEnabled(): Boolean {
                return false
            }

            override fun isContactEnable(): Boolean {
               return true
            }

            override fun isGroupEnable(): Boolean {
                return true
            }

            override fun isOtherProfileEnable(): Boolean {
                return true
            }

            override fun isOwnProfileEnable(): Boolean {
                return true
            }

            override fun isTrialLicenceKey(): Boolean {
                return true
            }
        })

        MirrorFlyUIKit.defaultThemeMode = MirrorFlyUIKit.ThemeMode.Light

    }
}
