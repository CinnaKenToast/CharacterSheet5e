package com.example.charactersheet.data

import androidx.room.TypeConverter
import com.example.charactersheet.data.character.AttackSpell
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
}