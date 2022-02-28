package com.shipsco.charactersheet.data.character

import kotlinx.serialization.Serializable

@Serializable
data class Spell(
    var totalSpellSlots: String = "",
    var spellSlotsExpended: String = "",
    var spellChecked: List<Boolean> = listOf(),
    var spellName: List<String> = listOf()
)

var blankSpells = listOf(
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) { false },
        spellName = List(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) { false },
        spellName = List(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) { false },
        spellName = List(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(13) { false },
        spellName = List(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(11) { false },
        spellName = List(11) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(11) { false },
        spellName = List(11) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(11) { false },
        spellName = List(11) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(9) { false },
        spellName = List(9) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = List(9) { false },
        spellName = List(9) { "" }
    )
)