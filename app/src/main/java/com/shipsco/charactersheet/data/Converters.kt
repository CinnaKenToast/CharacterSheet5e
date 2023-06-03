package com.shipsco.charactersheet.data

import androidx.room.TypeConverter
import com.shipsco.charactersheet.data.character.AttackSpell
import com.shipsco.charactersheet.data.character.Spell
import com.shipsco.charactersheet.utils.fromJsonString
import com.shipsco.charactersheet.utils.toJsonString

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
    fun fromSpellListToString(spell: List<Spell>): String {
        return spell.toJsonString()
    }

    @TypeConverter
    fun fromStringToSpellList(json: String): List<Spell> {
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

    @TypeConverter
    fun fromNotesListToString(notesList: List<List<String>>): String {
        return notesList.toJsonString()
    }

    @TypeConverter
    fun fromStringToNotesList(json: String): List<List<String>> {
        return json.fromJsonString()
    }
}