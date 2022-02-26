package com.example.charactersheet.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.data.character.CharacterDao
import com.example.charactersheet.data.spells.CharacterSpells
import com.example.charactersheet.data.spells.CharacterSpellsDao

@Database(entities = [Character::class, CharacterSpells::class], version = 1)
@TypeConverters(Converters::class)
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun characterSpellsDao(): CharacterSpellsDao

    companion object {
        @Volatile
        private var INSTANCE: CharacterDatabase? = null
        fun getInstance(context: Context): CharacterDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context,
                    CharacterDatabase::class.java,
                    "characterDatabase.db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}