package com.example.charactersheet.data.spells

interface CharacterSpellsRepository {
    suspend fun getListofCharacterSpells(): List<CharacterSpells>

    suspend fun getCharacterSpells(name: String): Result<CharacterSpells>

    suspend fun addCharacterSpells(characterSpells: CharacterSpells)

    suspend fun removeCharacterSpells(characterSpells: CharacterSpells)

    suspend fun updateCharacterSpells(characterSpells: CharacterSpells)
}