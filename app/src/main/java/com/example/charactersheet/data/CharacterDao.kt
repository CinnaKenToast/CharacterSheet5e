package com.example.charactersheet.data

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
    suspend fun getCharacter(characterName: String): Character

    @Query("SELECT * FROM character")
    suspend fun getListOCharacters(): List<Character>

    @Query("SELECT (1) FROM character WHERE (:characterName == `characterName`)")
    suspend fun characterExists(characterName: String): Boolean

    @Query("SELECT COUNT(*) == 0 FROM character")
    suspend fun tableIsEmpty(): Boolean
}