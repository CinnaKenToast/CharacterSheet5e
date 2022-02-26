package com.example.charactersheet.data.spells

import androidx.room.*

@Dao
interface CharacterSpellsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(characterSpells: CharacterSpells)

    @Update
    suspend fun update(characterSpells: CharacterSpells)

    @Delete
    suspend fun delete(characterSpells: CharacterSpells)

    @Query("SELECT * FROM characterSpells WHERE (:characterName == `characterName`)")
    suspend fun getCharacterSpells(characterName: String): CharacterSpells?

    @Query("SELECT * FROM characterSpells")
    suspend fun getListOfCharacterSpells(): List<CharacterSpells>
}