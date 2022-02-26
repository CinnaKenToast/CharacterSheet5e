package com.example.charactersheet.data.character

import androidx.room.*

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(character: Character)

    @Update
    suspend fun update(character: Character)

    @Delete
    suspend fun delete(character: Character)

    @Query("SELECT * FROM character WHERE (:characterName == `characterName`)")
    suspend fun getCharacter(characterName: String): Character?

    @Query("SELECT * FROM character")
    suspend fun getListOfCharacters(): List<Character>
}