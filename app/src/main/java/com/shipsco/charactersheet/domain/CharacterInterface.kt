package com.shipsco.charactersheet.domain

import com.shipsco.charactersheet.data.character.Character

interface CharacterInterface {
    suspend fun getCharacters(): List<Character>

    suspend fun getCharacter(name: String): Result<Character>

    suspend fun addCharacter(character: Character)

    suspend fun removeCharacter(character: Character)

    suspend fun updateCharacter(character: Character)
}