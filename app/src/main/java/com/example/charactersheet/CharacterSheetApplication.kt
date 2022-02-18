package com.example.charactersheet

import android.app.Application

class CharacterSheetApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        CharacterSheetApplication.instance = this
    }

    companion object {
        lateinit var instance: CharacterSheetApplication
            private set
    }
}