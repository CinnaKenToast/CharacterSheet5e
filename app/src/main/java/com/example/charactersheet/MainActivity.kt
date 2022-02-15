package com.example.charactersheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = CharacterViewModelFactory(application)
        characterViewModel = ViewModelProvider(this, factory).get(CharacterViewModel::class.java)
    }
}