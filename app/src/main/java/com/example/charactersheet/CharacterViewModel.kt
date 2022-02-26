package com.example.charactersheet

import android.app.Application
import androidx.lifecycle.*
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.data.CharacterDatabase
import com.example.charactersheet.domain.CharacterUseCase
import kotlinx.coroutines.launch

class CharacterViewModel(
    application: Application,
    private val characterUseCase: CharacterUseCase
): AndroidViewModel(application) {
    val characterDao = CharacterDatabase.getInstance(getApplication<Application>().applicationContext).characterDao()
    private val _allCharacters = MutableLiveData<List<Character>>()
    val allCharacters: LiveData<List<Character>> = _allCharacters

    fun getCharacters() {
        viewModelScope.launch {
            _allCharacters.postValue(characterUseCase.getCharacters())
        }
    }

    fun saveCharacter(newCharacter: Character) {
        viewModelScope.launch {
            characterUseCase.getCharacter(newCharacter.characterName)
                .onSuccess {
                    characterUseCase.updateCharacter(newCharacter)

                    _allCharacters.postValue(characterUseCase.getCharacters())
                }
                .onFailure {
                    characterUseCase.addCharacter(newCharacter)

                    _allCharacters.postValue(characterUseCase.getCharacters())
                }
        }
    }

    fun deleteCharacter(character: Character) {
        viewModelScope.launch {
            characterUseCase.removeCharacter(character)

            _allCharacters.postValue(characterUseCase.getCharacters())
        }
    }
}

class CharacterViewModelFactory(private val application: Application): ViewModelProvider.Factory {
     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(
                application = application,
                characterUseCase = CharacterUseCase.createInstance(application.applicationContext)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}