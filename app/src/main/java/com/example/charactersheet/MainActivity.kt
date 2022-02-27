package com.example.charactersheet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = CharacterViewModelFactory(application)
        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]
    }

    override fun onBackPressed() {
//        val characterName = characterViewModel.currentCharacter.value?.characterName
//        characterName?.let {
//            if (characterName.isBlank()) {
//                MaterialAlertDialogBuilder(applicationContext)
//                    .setTitle("Are you sure?")
//                    .setMessage("In order to save your character, please give it a name. Otherwise any changes will be lost.")
//                    .setNegativeButton("Cancel") { dialog, which ->
//                        dialog.dismiss()
//                    }
//                    .setPositiveButton("Go Back") { dialog, which ->
//                        super.onBackPressed()
//                    }
//                    .show()
//            }
//        }
        super.onBackPressed()
    }
}