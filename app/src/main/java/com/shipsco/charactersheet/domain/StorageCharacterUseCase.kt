package com.shipsco.charactersheet.domain

import android.content.Context
import com.google.gson.GsonBuilder
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.utils.fromJsonString
import com.shipsco.charactersheet.utils.toJsonString
import java.io.File

class StorageCharacterUseCase(
    private val context: Context
): CharacterInterface {
    override suspend fun getCharacters(): List<Character> {
        TODO("Not yet implemented")
        // context.filesDir.listFiles() gets a list of files
        // File.isFile, File.isDirectory
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

    suspend fun getCharacterFile(character: Character) : Result<File> {
        val file = File(context.filesDir, "${character.characterName}.char")
        return if ( file.exists() ) {
            Result.success(file)
        } else {
            Result.failure(Throwable("Could not find character files: ${character.characterName}"))
        }
    }

    override suspend fun addCharacter(character: Character) {
        val characterJson = character.toJsonString()
        val gson = GsonBuilder().setPrettyPrinting().create()
        val company = gson.fromJson(characterJson, Character::class.java)

        val prettyJsonString = gson.toJson(company)
        val file = File(context.filesDir, "${character.characterName}.char")
        file.writeText(prettyJsonString)
    }

    override suspend fun removeCharacter(character: Character) {
        val file = File(context.filesDir, "${character.characterName}.char")
        file.delete()
    }

    override suspend fun updateCharacter(character: Character) {
        val characterJson = character.toJsonString()
        val gson = GsonBuilder().setPrettyPrinting().create()
        val company = gson.fromJson(characterJson, Character::class.java)

        val prettyJsonString = gson.toJson(company)
        val file = File(context.filesDir, "${character.characterName}.char")
        file.writeText(prettyJsonString)
    }

    companion object {
        fun createInstance(context: Context): StorageCharacterUseCase {
            return StorageCharacterUseCase(
                context = context
            )
        }
    }
}