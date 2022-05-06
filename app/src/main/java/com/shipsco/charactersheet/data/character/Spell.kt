package com.shipsco.charactersheet.data.character

import kotlinx.serialization.Serializable

@Serializable
data class Spell(
    var totalSpellSlots: String = "",
    var spellSlotsExpended: String = "",
    var spellChecked: MutableList<Boolean> = mutableListOf(),
    var spellName: MutableList<String> = mutableListOf()
)

var blankSpells = listOf(
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(13) { false },
        spellName = MutableList(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(13) { false },
        spellName = MutableList(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(13) { false },
        spellName = MutableList(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(13) { false },
        spellName = MutableList(13) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(11) { false },
        spellName = MutableList(11) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(11) { false },
        spellName = MutableList(11) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(11) { false },
        spellName = MutableList(11) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(9) { false },
        spellName = MutableList(9) { "" }
    ),
    Spell(
        totalSpellSlots = "",
        spellSlotsExpended = "",
        spellChecked = MutableList(9) { false },
        spellName = MutableList(9) { "" }
    )
)