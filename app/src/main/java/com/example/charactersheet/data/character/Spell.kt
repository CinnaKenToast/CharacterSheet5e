package com.example.charactersheet.data.character

import kotlinx.serialization.Serializable

@Serializable
data class Spell(
    var totalSpellSlots: String = "",
    var spellSlotsExpended: String = "",
    var spellChecked: List<Boolean> = listOf(),
    var spellName: List<String> = listOf()
)
