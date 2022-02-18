package com.example.charactersheet.data.character

class RoomCharacterRepository(
    private val characterDao: CharacterDao
): CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return characterDao.getListOfCharacters()
    }

    override suspend fun getCharacter(name: String): Result<Character> {
        return try {
            Result.success(characterDao.getCharacter(characterName = name)!!)
        } catch (throwable: Throwable) {
            Result.failure(
                Throwable(
                    message = "${RoomCharacterRepository::class.java.name}: Failed to get character for $name.\n${throwable.message}"
                )
            )
        }
    }

    override suspend fun addCharacter(character: Character) {
        characterDao.insert(character)
    }

    override suspend fun removeCharacter(character: Character) {
        characterDao.delete(character)
    }

    override suspend fun updateCharacter(character: Character) {
        characterDao.update(character)
    }
}