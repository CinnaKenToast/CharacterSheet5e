package com.example.charactersheet.data.spells

import com.example.charactersheet.data.character.RoomCharacterRepository

class RoomCharacterSpellsRepository(
    private val characterSpellsDao: CharacterSpellsDao
): CharacterSpellsRepository {
    override suspend fun getListofCharacterSpells(): List<CharacterSpells> {
        return characterSpellsDao.getListOfCharacterSpells()
    }

    override suspend fun getCharacterSpells(name: String): Result<CharacterSpells> {
        return try {
            Result.success(characterSpellsDao.getCharacterSpells(characterName = name)!!)
        } catch (throwable: Throwable) {
            Result.failure(
                Throwable(
                    message = "${RoomCharacterSpellsRepository::class.java.name}: Failed to get character for $name.\n${throwable.message}"
                )
            )
        }
    }

    override suspend fun addCharacterSpells(characterSpells: CharacterSpells) {
        characterSpellsDao.insert(characterSpells)
    }

    override suspend fun removeCharacterSpells(characterSpells: CharacterSpells) {
        characterSpellsDao.delete(characterSpells)
    }

    override suspend fun updateCharacterSpells(characterSpells: CharacterSpells) {
        characterSpellsDao.update(characterSpells)
    }
}