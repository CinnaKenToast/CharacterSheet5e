package com.shipsco.charactersheet.domain

import android.content.Context
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.utils.fromJsonString
import com.shipsco.charactersheet.utils.toJsonString
import java.io.File

class StorageCharacterUseCase(
    private val context: Context
): CharacterInterface {
    override suspend fun getCharacters(): List<Character> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacter(name: String): Result<Character> {
        val file = File(context.filesDir, "${name}.char")
        val characterJson = file.readText()
        return if ( characterJson.isBlank() ) {
            Result.failure(Throwable("Could not find character: $name"))
        } else {
            Result.success(characterJson.fromJsonString())
        }
    }

    override suspend fun addCharacter(character: Character) {
        val characterJson = character.toJsonString()
        val file = File(context.filesDir, "${character.characterName}.char")
        file.writeText(characterJson)
    }

    override suspend fun removeCharacter(character: Character) {
        val file = File(context.filesDir, "${character.characterName}.char")
        file.delete()
    }

    override suspend fun updateCharacter(character: Character) {
        val characterJson = character.toJsonString()
        val file = File(context.filesDir, "${character.characterName}.char")
        file.writeText(characterJson)
    }

    companion object {
        fun createInstance(context: Context): StorageCharacterUseCase {
            return StorageCharacterUseCase(
                context = context
            )
        }
    }
}