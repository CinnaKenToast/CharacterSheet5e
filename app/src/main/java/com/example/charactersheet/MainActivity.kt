package com.example.charactersheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = CharacterViewModelFactory(application)
        characterViewModel = ViewModelProvider(this, factory).get(CharacterViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val currentFragment = supportFragmentManager.fragments.last().childFragmentManager.fragments.last()
        if (currentFragment is DetailsFragment) {
            val inflater = MenuInflater(applicationContext)
            inflater.inflate(R.menu.character_sheet_menu, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }
}