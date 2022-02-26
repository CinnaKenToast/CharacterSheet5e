package com.example.charactersheet.domain

import android.content.Context
import com.example.charactersheet.data.CharacterDatabase
import com.example.charactersheet.data.spells.CharacterSpells
import com.example.charactersheet.data.spells.CharacterSpellsRepository
import com.example.charactersheet.data.spells.RoomCharacterSpellsRepository

class CharacterSpellsUseCase(
    private val characterSpellsRepository: CharacterSpellsRepository
) {
    suspend fun getListofCharacterSpells() = characterSpellsRepository.getListofCharacterSpells()

    suspend fun getCharacterSpells(name: String) = characterSpellsRepository.getCharacterSpells(name)

    suspend fun addCharacterSpells(characterSpells: CharacterSpells) = characterSpellsRepository.addCharacterSpells(characterSpells)

    suspend fun removeCharacterSpells(characterSpells: CharacterSpells) = characterSpellsRepository.removeCharacterSpells(characterSpells)

    suspend fun updateCharacterSpells(characterSpells: CharacterSpells) = characterSpellsRepository.updateCharacterSpells(characterSpells)

    companion object {
        fun createInstance(context: Context): CharacterSpellsUseCase {
            return CharacterSpellsUseCase(
                characterSpellsRepository = RoomCharacterSpellsRepository(
                    characterSpellsDao = CharacterDatabase.getInstance(context).characterSpellsDao()
                )
            )
        }
    }
}