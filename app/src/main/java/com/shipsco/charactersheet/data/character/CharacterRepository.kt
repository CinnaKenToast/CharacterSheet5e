package com.shipsco.charactersheet.data.character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun getCharacter(name: String): Result<Character>

    suspend fun addCharacter(character: Character)

    suspend fun removeCharacter(character: Character)

    suspend fun updateCharacter(character: Character)
}