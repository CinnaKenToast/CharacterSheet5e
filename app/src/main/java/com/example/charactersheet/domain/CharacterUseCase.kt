package com.example.charactersheet.domain

import android.content.Context
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.data.character.CharacterDatabase
import com.example.charactersheet.data.character.CharacterRepository
import com.example.charactersheet.data.character.RoomCharacterRepository

class CharacterUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend fun getCharacters(): List<Character> = characterRepository.getCharacters()

    suspend fun getCharacter(name: String): Result<Character> =
        characterRepository.getCharacter(name)

    suspend fun addCharacter(character: Character) = characterRepository.addCharacter(character)

    suspend fun removeCharacter(character: Character) =
        characterRepository.removeCharacter(character)

    suspend fun updateCharacter(character: Character) =
        characterRepository.updateCharacter(character)

    companion object {
        fun createInstance(context: Context): CharacterUseCase {
            return CharacterUseCase(
                characterRepository = RoomCharacterRepository(
                    characterDao = CharacterDatabase.getInstance(context).characterDao()
                )
            )
        }
    }
}