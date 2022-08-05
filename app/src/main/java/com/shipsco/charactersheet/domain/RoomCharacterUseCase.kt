package com.shipsco.charactersheet.domain

import android.content.Context
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.data.character.CharacterDatabase
import com.shipsco.charactersheet.data.character.CharacterRepository
import com.shipsco.charactersheet.data.character.RoomCharacterRepository

class RoomCharacterUseCase(
    private val characterRepository: CharacterRepository
): CharacterInterface {
    override suspend fun getCharacters(): List<Character> = characterRepository.getCharacters()

    override suspend fun getCharacter(name: String): Result<Character> =
        characterRepository.getCharacter(name)

    override suspend fun addCharacter(character: Character) = characterRepository.addCharacter(character)

    override suspend fun removeCharacter(character: Character) =
        characterRepository.removeCharacter(character)

    override suspend fun updateCharacter(character: Character) =
        characterRepository.updateCharacter(character)

    companion object {
        fun createInstance(context: Context): RoomCharacterUseCase {
            return RoomCharacterUseCase(
                characterRepository = RoomCharacterRepository(
                    characterDao = CharacterDatabase.getInstance(context).characterDao()
                )
            )
        }
    }
}