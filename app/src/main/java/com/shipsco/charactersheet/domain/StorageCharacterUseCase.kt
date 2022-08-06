package com.shipsco.charactersheet.domain

import com.shipsco.charactersheet.data.character.Character

class StorageCharacterUseCase: CharacterInterface {
    override suspend fun getCharacters(): List<Character> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacter(name: String): Result<Character> {
        TODO("Not yet implemented")
    }

    override suspend fun addCharacter(character: Character) {
        TODO("Not yet implemented")
    }

    override suspend fun removeCharacter(character: Character) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCharacter(character: Character) {
        TODO("Not yet implemented")
    }
}