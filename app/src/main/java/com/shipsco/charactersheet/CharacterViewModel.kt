package com.shipsco.charactersheet

import android.app.Application
import android.text.Editable
import android.text.SpannableStringBuilder
import androidx.lifecycle.*
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.domain.CharacterUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CharacterViewModel(
    application: Application,
    private val characterUseCase: CharacterUseCase
): AndroidViewModel(application) {
    private val _allCharacters = MutableLiveData<List<Character>>()
    val allCharacters: LiveData<List<Character>> = _allCharacters

    private val _currentCharacter = MutableLiveData<Character>()
    val currentCharacter: LiveData<Character> = _currentCharacter

    fun getCharacters() {
        runBlocking {
            _allCharacters.postValue(characterUseCase.getCharacters())
        }
    }

    fun setCharacter(character: Character) {
        _currentCharacter.postValue(character)
    }

    fun getCharacter(characterName: String): Character {
        var character = Character()
        runBlocking {
            characterUseCase.getCharacter(characterName)
                .onSuccess {
                    character = it
                }
                .onFailure {  }
        }
        _currentCharacter.postValue(character)
        return character
    }

    fun saveCharacter(newCharacter: Character) {
        if (newCharacter.characterName.isNotBlank()) {
            viewModelScope.launch {
                characterUseCase.getCharacter(newCharacter.characterName)
                    .onSuccess {
                        characterUseCase.updateCharacter(newCharacter)
                        _currentCharacter.postValue(newCharacter)
                        _allCharacters.postValue(characterUseCase.getCharacters())
                    }
                    .onFailure {
                        characterUseCase.addCharacter(newCharacter)
                        _currentCharacter.postValue(newCharacter)
                        _allCharacters.postValue(characterUseCase.getCharacters())
                    }
            }
        }
    }

    fun deleteCharacter(character: Character) {
        viewModelScope.launch {
            characterUseCase.removeCharacter(character)

            _allCharacters.postValue(characterUseCase.getCharacters())
        }
    }

    fun saveCurrentCharacter() {
        runBlocking {
            saveCharacter(currentCharacter.value!!)
        }
    }

    fun setStrengthBonus(strength: Editable) {

        saveCurrentCharacter()
        runBlocking {
            delay(1000)
            val strengthBase = strength.toString().toInt() - 10
            val strengthBonus = strengthBase / 2
            var strengthBonusString = strengthBonus.toString()
            if (!strengthBonusString.contains('-')) {
                strengthBonusString = "+$strengthBonusString"
            }
            currentCharacter.value?.strengthBonus = strengthBonusString
            updateStrengthBonuses(SpannableStringBuilder(strengthBonusString))
        }
    }

    fun updateStrengthBonuses(strengthBonus: Editable) {
        currentCharacter.value?.let { currentCharacter ->
            val bonus = strengthBonus.toString()
            currentCharacter.strengthSave = bonus
            currentCharacter.athletics = bonus
            saveCurrentCharacter()
//            FragmentDetailsBinding.inflate(LayoutInflater.from(getApplication<Application?>().applicationContext)).invalidateAll()
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