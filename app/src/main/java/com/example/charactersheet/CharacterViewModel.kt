package com.example.charactersheet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.charactersheet.data.Character
import com.example.charactersheet.data.CharacterDatabase
import kotlinx.coroutines.runBlocking

class CharacterViewModel(application: Application): AndroidViewModel(application) {
    val characterDao = CharacterDatabase.getInstance(getApplication<Application>().applicationContext).characterDao()

    fun getCharacters(): List<Character> {
        var characters: List<Character>
        runBlocking {
            characters = characterDao.getListOCharacters()
        }
        return characters
    }

    fun saveCharacter(character: Character) {
        runBlocking {
            val databaseCharacter = characterDao.getCharacter(character.characterName)
            databaseCharacter?.let {
                characterDao.update(character)
            } ?: characterDao.insert(character)
        }
    }
}

class CharacterViewModelFactory(private val application: Application): ViewModelProvider.Factory {
     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}