package com.shipsco.charactersheet.domain

import android.content.Context
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.data.character.CharacterDatabase
import com.shipsco.charactersheet.data.character.CharacterRepository
import com.shipsco.charactersheet.data.character.RoomCharacterRepository

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