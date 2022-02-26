package com.example.charactersheet.data.spells

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "characterSpells")
@Serializable
data class CharacterSpells(
    @PrimaryKey(autoGenerate = false)
    var characterName: String = "",
    var spellCastingClass: String = "",
    var spellCastingAbility: String = "",
    var spellSaveDC: String = "",
    var spellAttackBonus: String = "",
    var cantrips: List<String> = List(8) { "" },
    var level1Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) {false},
        spellName = List(13) {"false"}
    ),
    var level2Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) {false},
        spellName = List(13) {"false"}
    ),
    var level3Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) {false},
        spellName = List(13) {"false"}
    ),
    var level4Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) {false},
        spellName = List(13) {"false"}
    ),
    var level5Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(11) {false},
        spellName = List(11) {"false"}
    ),
    var level6Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(11) {false},
        spellName = List(11) {"false"}
    ),
    var level7Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(11) {false},
        spellName = List(11) {"false"}
    ),
    var level8Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(9) {false},
        spellName = List(9) {"false"}
    ),
    var level9Spells: Spell = Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(9) {false},
        spellName = List(9) {"false"}
    )
)

val blankCharacterSpells = CharacterSpells()