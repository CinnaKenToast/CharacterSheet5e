package com.example.charactersheet.data

import androidx.room.TypeConverter
import com.example.charactersheet.data.character.AttackSpell
import com.example.charactersheet.data.character.Spell
import com.example.charactersheet.utils.fromJsonString
import com.example.charactersheet.utils.toJsonString

class Converters {
    @TypeConverter
    fun fromAttackSpellsToString(attackSpells: List<AttackSpell>): String {
        return attackSpells.toJsonString()
    }

    @TypeConverter
    fun fromStringToAttackSpells(json: String): List<AttackSpell> {
        return json.fromJsonString()
    }

    @TypeConverter
    fun fromSpellToString(spell: Spell): String {
        return spell.toJsonString()
    }

    @TypeConverter
    fun fromStringToSpell(json: String): Spell {
        return json.fromJsonString()
    }

    @TypeConverter
    fun fromStringListToString(stringList: List<String>): String {
        return stringList.toJsonString()
    }

    @TypeConverter
    fun fromStringToSStringList(json: String): List<String> {
        return json.fromJsonString()
    }
}